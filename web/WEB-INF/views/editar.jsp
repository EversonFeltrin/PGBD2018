<%-- 
    Document   : editar
    Created on : 28/11/2018, 01:12:47
    Author     : efelt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h2><strong>Editar ACG:</strong></h2>
            <form action = "updateAcg" method = "POST">
                <label for = "matricula">Matricula:</label>
                <input type = "text" name="matricula" value='${aluno.matricula}' readonly>
                <label for = "nome">Nome Completo:</label>
                <input type = "text" name="nome" value='${aluno.nome}' readonly>
                <label for = "idAtividade">Identificador da Atividade:</label>
                <input type = "number" name="idAtividade" value='${atividade.idAtividade}' readonly>
                <label for = "classificacao">Classificação da Atividade:</label>
                <input type = "text" name="classificacao" value='${atividade.classificacao}'>
                <label for = "local">Local da Atividade:</label>
                <input type = "text" name="local" value='${atividade.localAtividade}'>
                <label for = "periodoIni">Período - Data Inicio:</label>
                <input type = "text" name="periodoIni" value='${atividade.dataIni}'>
                <label for = "periodoFim">Período - Data Inicio:</label>
                <input type = "text" name="periodoFim" value='${atividade.dataFim}'>
                <label for = "horas">Carga Horária:</label>
                <input type = "number" name="horas" value='${atividade.cargaHoraria}'>
                <label for = "atividade">Atividade Desenvolvida:</label>
                <input type = "text" name="atividade" value='${atividade.atividadeDesenvolvida}'>
                <label for = "dataSub">Data de Submissão:</label>
                <input type = "text" name="dataSub" value='${atividade.dataSubmissao}'>
                <button type="submit">Atualizar ACG</button>
            </form>
        </div>
    </body>
</html>

