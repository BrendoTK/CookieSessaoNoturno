package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("<html><body>");
        if(session!=null)
        {
            out.print("Tchau "+session.getAttribute("login"));
            session.invalidate();
        }
        out.println("</body></html>");

    }
}
