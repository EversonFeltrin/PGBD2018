<%-- 
    Document   : dashboard
    Created on : 12/10/2018, 22:59:35
    Author     : efelt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class ="container-fluid">
            <div class ="navbar">
                    <h2><strong>Inserir ACG:</strong></h2>
                    <form action = "cadastrarAcg" method = "POST">
                        <label for = "matricula">Matricula:</label>
                        <input type = "text" name="matricula" value='${aluno.matricula}' readonly>
                        <label for = "nome">Nome Completo:</label>
                        <input type = "text" name="nome" value='${aluno.nome}' readonly>
                        <label for = "classificacao">Classificação da Atividade:</label>
                        <input type = "text" name="classificacao" required>
                        <label for = "local">Local da Atividade:</label>
                        <input type = "text" name="local" required>
                        <label for = "periodoIni">Período - Data Inicio:</label>
                        <input type = "text" name="periodoIni">
                        <label for = "periodoFim">Período - Data Inicio:</label>
                        <input type = "text" name="periodoFim">
                        <label for = "horas">Carga Horária:</label>
                        <input type = "number" name="horas" required>
                        <label for = "atividade">Atividade Desenvolvida:</label>
                        <input type = "text" name="atividade" required>
                        <label for = "dataSub">Data de Submissão:</label>
                        <input type = "text" name="dataSub" required>
                        <button type="submit">Inserir ACG</button>
                    </form>
            </div>
            <div>
                <h2><strong>Listagem de ACGs:</strong></h2>         
               
                <!-- Observar que os campos seguem a nomenclatura do model -->
                <c:forEach var="atividade" items="${atividade}">
                  
                    <li>                    
                        ${atividade.idAtividade} - ${atividade.classificacao} - ${atividade.dataIni} -  ${atividade.dataFim} - 
                        <!--<a href="http://localhost:8080/trats/associado?matricula=${assoc.matAssociado}&acao=editar">Editar</a> - 
                        <a href="http://localhost:8080/trats/associado?matricula=${assoc.matAssociado}&acao=deletar">Deletar</a>
                        -->
                    <li>  
                </c:forEach>
            
            </div>
        </div>
        
       
        
        
        
    </body>
</html>
