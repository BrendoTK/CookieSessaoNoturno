package aula.cookiesessaonoturno;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/computador")
public class Computador extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Adiciona um cookie ao visitar a página sem estar logado
        HttpSession session = request.getSession(false);
        out.println("<html><body>");
        if (session == null) {

            // Adiciona um novo cookie "computador"
            Cookie cookie = new Cookie("Produto_Computador", "10000");
            cookie.setMaxAge(3600); // Define a validade do cookie (em segundos)

            // Adiciona o novo cookie à resposta
            response.addCookie(cookie);
        }

        // Exibe informações sobre o computador
        out.print("<p>Computador potente</p>");
        out.print("<p>Valor: R$10.000</p>");
        out.println("</body></html>");
    }
}
