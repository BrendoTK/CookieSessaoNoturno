package aula.cookiesessaonoturno;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/verificacookie")
public class VerificaCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        Cookie[] cs=request.getCookies();
        if(cs!=null)
            for(Cookie c:cs)
            {
                out.print("<p>"+c.getName()+" = "+c.getValue());
            }
        out.println("</body></html>");
    }

}