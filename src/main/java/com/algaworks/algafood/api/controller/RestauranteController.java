package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes")
public class RestauranteController {

    public final RestauranteRepository restauranteRepository;

    public final CadastroRestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.todos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> bustar(@PathVariable Long id) {
        Restaurante restaurante = restauranteRepository.porId(id);

        if(restaurante != null)
            return ResponseEntity.ok(restaurante);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(restauranteService.salvar(restaurante));
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteAtual = restauranteRepository.porId(id);

            if (restaurante != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                return ResponseEntity.ok(restauranteService.salvar(restaurante));
            }
            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            restauranteService.excluir(id);

            return ResponseEntity
                    .noContent()
                    .build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}