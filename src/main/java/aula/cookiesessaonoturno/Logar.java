package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        if(login!=null && senha !=null)
        {
            if(login.equals("jose") && senha.equals("123") || login.equals("brendo") && senha.equals("123") || login.equals("nicoly") && senha.equals("123"))
            {
                HttpSession sessao=request.getSession(true);
                sessao.setAttribute("login",login);
                out.print("<p>Logado com sucesso: "+login);
                out.print("<p><a href='sair'>Sair</a></p>");
            }
            else
                out.print("<p>Login ou senha incorretos");
        }else
            out.print("<p>Informe o nome e a senha");
    }
}
