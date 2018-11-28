/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.controller_servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pgbd.dao.AlunosDAOPostgreSQL;
import pgbd.dao.AtividadesDAOPostgreSQL;
import pgbd.model.Alunos;
import pgbd.model.Atividades;

/**
 *
 * @author efelt
 */
@WebServlet(name = "updateAcg", urlPatterns = {"/updateAcg"})
public class updateAcgServelet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Alunos aluno = new AlunosDAOPostgreSQL().read_aluno(req.getParameter("nome"), req.getParameter("matricula"));
        RequestDispatcher disp;
        req.setAttribute("aluno", new AlunosDAOPostgreSQL().read_aluno(aluno.getIdAluno()));
        
        
        Atividades ativ = new Atividades();
        ativ.setIdAtividade(Integer.parseInt(req.getParameter("idAtividade")));
        ativ.setClassificacao(req.getParameter("classificacao"));
        ativ.setLocalAtividade(req.getParameter("local"));
        ativ.setDataIni(req.getParameter("periodoIni"));
        ativ.setDataFim(req.getParameter("periodoFim"));
        ativ.setCargaHoraria(Integer.parseInt(req.getParameter("horas")));
        ativ.setAtividadeDesenvolvida(req.getParameter("atividade"));
        ativ.setDataSubmissao(req.getParameter("dataSub"));
        ativ.setIdAluno(aluno.getIdAluno());
    
        boolean updateAtividade = new AtividadesDAOPostgreSQL().update_atividade(ativ);
        
        if (updateAtividade == true){
            System.out.println("Atividade atualizada com sucesso...\n");
        }
        else{
            System.out.println("Erro ao atualizar atividade...\n");
        }
        req.setAttribute("atividade", new AlunosDAOPostgreSQL().getAtividades(aluno.getIdAluno()));
        disp = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
        disp.forward(req, resp);
    }
}
