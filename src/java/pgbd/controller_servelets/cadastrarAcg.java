/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.controller_servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pgbd.dao.AlunosDAOPostgreSQL;
import pgbd.model.Alunos;
import pgbd.model.Atividades;

/**
 *
 * @author efelt
 */
@WebServlet(name = "cadastrarAcg", urlPatterns = {"/cadastrarAcg"})
public class cadastrarAcg extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //instancia o novo aluno
        Alunos aluno = new Alunos();
        aluno.setNome(req.getParameter("nome"));
        aluno.setMatricula(req.getParameter("matricula"));
        System.out.println(aluno.getNome()+ " - "+aluno.getMatricula()+"\n");
        
        
        
        //instancia a atividade que está sendo cadastrada
        Atividades at = new Atividades();
        at.setClassificacao(req.getParameter("classificacao"));
        at.setLocalAtividade(req.getParameter("local"));
        at.setDataIni(req.getParameter("periodoIni"));
        at.setDataFim(req.getParameter("periodoFim"));
        at.setCargaHoraria(Integer.parseInt(req.getParameter("horas")));
        at.setAtividadeDesenvolvida(req.getParameter("atividade"));
        at.setDataSubmissao(req.getParameter("dataSub"));
//        
//        
//        ArrayList<Atividades> arrayAtiv = new ArrayList<Atividades>();  
//        arrayAtiv = new AlunosDAOPostgreSQL().setArrayAtividades(arrayAtiv, at);
//        aluno.setAtividades(arrayAtiv);
//        
////        arrayAtiv = new AlunosDAOPostgreSQL().setArrayAtividades(arrayAtiv, at);
////        
//////        aluno.setAtividades(arrayAtiv);
////        
////        req.setAttribute("aluno", new AlunosDAOPostgreSQL().read_aluno(aluno.getNome(), aluno.getMatricula()));
////        req.setAttribute("acg", arrayAtiv);
//        
//        req.setAttribute("aluno", aluno.getAtividades());
//        req.setAttribute("acg", new AlunosDAOPostgreSQL().setArrayAtividades(arrayAtiv, at));
//        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
//        disp.forward(req, resp);
    }
}
