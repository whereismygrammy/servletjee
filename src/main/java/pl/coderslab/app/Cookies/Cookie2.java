package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2", urlPatterns = "/addToCookie")
public class Cookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.getWriter().println("Masz ciasteczko na 30 sekund.");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
