package aula.cookiesessaonoturno;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/limpacookie")
public class LimpaCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie cookie=new Cookie("Produto_Computador","10000");
        cookie.setMaxAge(0);
        response.addCookie(cookie);


        Cookie cookie2=new Cookie("Produto_Perfume","100");
        cookie2.setMaxAge(0);
        response.addCookie(cookie2);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.print("Coockies Removidos");
        out.println("</body></html>");
    }

}