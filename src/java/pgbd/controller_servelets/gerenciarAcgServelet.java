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

/**
 *
 * @author efelt
 */
@WebServlet(name = "gerenciarAcg", urlPatterns = {"/gerenciarAcg"})
public class gerenciarAcgServelet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String acao = req.getParameter("acao");
        int idAluno = Integer.parseInt(req.getParameter("idAluno"));
        if (acao.equals("editar")){
            System.out.println("Vai chamar para editar!");
        }
        if(acao.equals("deletar")){
            System.out.println("Vai deletar!");
            boolean deleteAtividade = new AtividadesDAOPostgreSQL().delete_atividade(Integer.parseInt(req.getParameter("idAtividade")));
            if (deleteAtividade == true){
                System.out.println("Atividade apagada...");
            }
            else {
                System.out.println("Erro ao apagar atividade...");
            }
        
        } 
        
        RequestDispatcher disp;
        req.setAttribute("aluno", new AlunosDAOPostgreSQL().read_aluno(idAluno));
        req.setAttribute("atividade", new AlunosDAOPostgreSQL().getAtividades(idAluno));
        disp = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
        disp.forward(req, resp);
            
            
        
    }

}
