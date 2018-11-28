create database "TrabPGBD";
drop database "TrabPGBD"; 
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


delete from aluno where idAluno = 2;

select * from aluno;

select * from atividade;