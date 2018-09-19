package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie4Del", urlPatterns = "/Cookie4Del")
public class Cookie4Del extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieName = request.getParameter("name");
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.getWriter().println("Usunięto ciasteczko o nazwie: " + cookieName);
    }
}
