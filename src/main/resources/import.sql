insert into cozinha (ID, NOME) values (1, 'Tailandesa');
insert into cozinha (ID, NOME) values (2, 'Indiana');

insert into restaurante (NOME, TAXA_FRETE, COZINHA_ID) values ('Thay Gourmet', 10, 1);
insert into restaurante (NOME, TAXA_FRETE, COZINHA_ID) values ('Thay Delivery', 9.5, 1);
insert into restaurante (NOME, TAXA_FRETE, COZINHA_ID) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into estado (ID, NOME) values (1, 'Minas Gerais');
insert into estado (ID, NOME) values (2, 'São Paulo');
insert into estado (ID, NOME) values (3, 'Ceará');

insert into cidade (NOME, ESTADO_ID) values ('Uberlândia', 1);
insert into cidade (NOME, ESTADO_ID) values ('Belo Horizonte', 1);
insert into cidade (NOME, ESTADO_ID) values ('São Paulo', 2);
insert into cidade (NOME, ESTADO_ID) values ('Campinas', 2);
insert into cidade (NOME, ESTADO_ID) values ('Fortaleza', 3);