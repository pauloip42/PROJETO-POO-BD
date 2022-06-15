USE organograma;

INSERT INTO nucleo VALUES(1, 'Software', 'Nucleo de Desenvolvimento', 'ND');
INSERT INTO nucleo VALUES(2, 'Gestão', 'Nucleo Assuntos Internos', 'NAI');
INSERT INTO nucleo VALUES(3, 'Comercial', 'Nucleo Comercial', 'NC');
INSERT INTO nucleo VALUES(4, 'Produção', 'Nucleo de Produção', 'NP');

INSERT INTO cliente VALUES(100, '12345678912341', 'cliente1@email.com', 'empresa1', 'responsavel1', '123456789121');
INSERT INTO cliente VALUES(101, '12345678912342', 'cliente2@email.com', 'empresa2', 'responsavel2', '223456789122');
INSERT INTO cliente VALUES(102, '12345678912343', 'cliente3@email.com', 'empresa3', 'responsavel3', '223456789123');
INSERT INTO cliente VALUES(104, '12345678912344', 'cliente4@email.com', 'empresa4', 'responsavel4', '223456789124');

INSERT INTO membro VALUES(100, 'Acessor', 'GEC', 'paulo@email.inatel.br', 'Paulo', 1);
INSERT INTO membro VALUES(101, 'Presidente', 'GEC', 'amanda@email.inatel.br', 'Amanda', 3);
INSERT INTO membro VALUES(102, 'Acessor', 'GEB', 'roberto@email.inatel.br', 'Roberto', 2);
INSERT INTO membro VALUES(103, 'Diretora', 'GEP', 'joana@email.inatel.br', 'Joana', 2);
INSERT INTO membro VALUES(104, 'Diretor', 'GEB', 'ygor@email.inatel.br', 'Ygor', 1);

INSERT INTO projeto VALUES(100, 'Madereira', 6000, 'Em andamento', 100);
INSERT INTO projeto VALUES(101, 'Quireli', 6000, 'Em andamento', 101);
INSERT INTO projeto VALUES(102, 'Casa do Pi', 6000, 'Em andamento', 102);

INSERT INTO projeto_membro VALUES(100, 100);
INSERT INTO projeto_membro VALUES(100, 101);
INSERT INTO projeto_membro VALUES(100, 104);

INSERT INTO projeto_membro VALUES(101, 101);
INSERT INTO projeto_membro VALUES(101, 103);
INSERT INTO projeto_membro VALUES(101, 104);

INSERT INTO projeto_membro VALUES(102, 100);
INSERT INTO projeto_membro VALUES(102, 102);
INSERT INTO projeto_membro VALUES(102, 104);

-- select * from projeto;

-- select * from membro;

-- select * from nucleo;

-- select * from cliente;

-- select * from projeto_membro;