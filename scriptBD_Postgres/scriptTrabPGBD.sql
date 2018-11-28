CREATE DATABASE "TrabPGBD"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "TrabPGBD"
    IS 'Database criado para o trabalho da disciplina de PGBD.';

create table aluno(
	id_aluno int not null,
	nome varchar(50) not null,
	matricula varchar(15) not null,
	primary key(id_aluno)
);
drop table atividade;
create table atividade(
	id_atividade int not null,
	classificacao varchar(50) not null,
	local_atividade varchar(50) not null,
	data_ini varchar(10) not null,
	data_fim varchar(10) not null,
	carga_horaria int not null,
	atividade_desenvolvida varchar(50) not null,
	data_submissao varchar(10) not null, 
	id_aluno int not null,
	primary key(id_atividade),
	foreign key(id_aluno) references aluno(id_aluno)
);


delete from atividade where id_atividade > 1;

select * from aluno;

select * from atividade;