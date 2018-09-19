package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie4Show", urlPatterns = "/Cookie4Show")
public class Cookie4Show extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        for (Cookie c : request.getCookies()) {
            String tempCookieInfo = c.getName() + " : " + c.getValue();
            response.getWriter().println("<a href=\"/Cookie4Del?name=" + c.getName() + "\">" + tempCookieInfo + "</a></br>");
        }


    }
}
