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
import pgbd.dao.AlunosDAO;
import pgbd.dao.AlunosDAOPostgreSQL;
import pgbd.model.Alunos;

/**
 *
 * @author efelt
 */
@WebServlet(name = "alunoAcg", urlPatterns = {"/alunoAcg"})
public class AlunosServelet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Alunos aluno = new Alunos();
        aluno.setNome(req.getParameter("nome"));
        aluno.setMatricula(req.getParameter("matricula"));
        System.out.println(aluno.getNome() + "-" + aluno.getMatricula());
        
        int create = new AlunosDAOPostgreSQL().create(aluno);
        System.out.println(create);
        if(create > 0){
            req.setAttribute("aluno", new AlunosDAOPostgreSQL().read_aluno(create));
        
            RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
        else{
            RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/index.html");
            disp.forward(req, resp);
        }       
    }
}
