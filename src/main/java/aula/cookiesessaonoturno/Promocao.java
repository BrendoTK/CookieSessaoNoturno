package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/promocao")
public class Promocao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        HttpSession session = request.getSession(false);
        // Verifica se o usuário está logado
        if (session != null && session.getAttribute("login") != null) {
            double resultado;
            Cookie[] cs = request.getCookies();
            if (cs != null)
                for (Cookie c : cs) {
                    if (c.getName().startsWith("Produto_")) {
                        String nomeProduto = c.getName().substring("Produto_".length());
                        double valor = Double.parseDouble(c.getValue());
                        resultado = valor - (valor * 0.1);
                        out.print("<p>Produto: " + nomeProduto + " | Valor com 10% de desconto: R$" + resultado);
                    }
                }
        } else
            out.print("Você não tem permissão para acessar essa página, por favor faça login no sistema.");

        out.println("</body></html>");
    }
}