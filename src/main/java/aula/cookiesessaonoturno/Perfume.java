package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/perfume")
public class Perfume extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Adiciona um cookie ao visitar a página sem estar logado
        HttpSession session = request.getSession(false);
        out.println("<html><body>");
        if (session == null) {

            // Adiciona um novo cookie "perfume"
            Cookie cookie = new Cookie("Produto_Perfume", "100");
            cookie.setMaxAge(3600); // Define a validade do cookie (em segundos)

            // Adiciona o novo cookie à resposta
            response.addCookie(cookie);
        }

        // Exibe informações sobre o perfume
        out.print("<p>Perfume bem cheiroso</p>");
        out.print("<p>Valor: R$100</p>");
        out.println("</body></html>");
    }
}
