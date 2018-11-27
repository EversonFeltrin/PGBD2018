create database "TrabPGBD";

create table aluno(
	idAluno int not null,
	nome varchar(50) not null,
	matricula varchar(15) not null,
	primary key(idAluno)
);

create table atividade(
	idAtividade int not null,
	classificacao varchar(50) not null,
	localAtividade varchar(50) not null,
	dataIni varchar(10) not null,
	dataFim varchar(10) not null,
	cargaHoraria int not null,
	atividadeDesenvolvida varchar(50) not null,
	dataSubmissao varchar(10) not null, 
	idAluno int not null,
	primary key(idAtividade),
	foreign key(idAluno) references aluno(idAluno)
);
