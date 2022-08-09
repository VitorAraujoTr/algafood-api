package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
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
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;

    private final CadastroEstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscar(@PathVariable Long id){
        return ResponseEntity.ok(estadoRepository.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estado> adicionar(@RequestBody Estado estado) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(estadoService.salvar(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long id, @RequestBody Estado estado) {
        Estado estadoAtual = estadoRepository.buscarPorId(id);

        if(estadoAtual != null) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            return ResponseEntity
                    .ok(estadoService.salvar(estadoAtual));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            estadoService.excluir(id);

            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

    }

}
