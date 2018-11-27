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
        String nome = req.getParameter("nome");
        String matricula = req.getParameter("matricula");
        int idAluno;
        Alunos aluno;
        //verifica se o aluno tem registro no banco de dados 
        aluno = new AlunosDAOPostgreSQL().read_aluno(nome, matricula);
        //caso não encontre o aluno cria um registro no banco e seta o idAluno
        if (aluno == null){
            System.out.println("Aluno não está no BD, precisa cadastrar...\n");
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            System.out.println(aluno.getNome() + "-" + aluno.getMatricula());            
            int create = new AlunosDAOPostgreSQL().create(aluno);
            System.out.println(create);            
            idAluno = create;
               
        }
        else{
            //caso o aluno exista no banco seta o idAluno
            idAluno = aluno.getIdAluno();
        }
        //verifica se existe um idAluno válido e redireciona      
        if(idAluno > 0){
            req.setAttribute("aluno", new AlunosDAOPostgreSQL().read_aluno(idAluno));
            RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
        else{
            RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/index.html");
            disp.forward(req, resp);
        }       
    }
}
