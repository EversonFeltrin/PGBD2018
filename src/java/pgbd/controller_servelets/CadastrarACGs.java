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

/**
 *
 * @author efelt
 */
@WebServlet(urlPatterns = {"/cadastrarACGs"})
public class CadastrarACGs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException{
        //recebe os dados via requisição
        String nome = req.getParameter("nome");
        String matricula = req.getParameter("matricula");
        
        System.err.println("Nome: " + nome + " Matricula: " + matricula);
        
        RequestDispatcher disp;
        boolean autenticado = false;
        //definir a logica apenas para teste
        if (autenticado){
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req,resp);     
        }else {
            disp = req.getRequestDispatcher("index.html");
            disp.forward(req,resp);    
        } 
        
    }
    
            
}
