package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Del", urlPatterns = "/deleteCookie")
public class Cookie1Del extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookieToDelete = new Cookie("User", "");
        cookieToDelete.setPath("/");
        cookieToDelete.setMaxAge(0);
        response.addCookie(cookieToDelete);
        response.getWriter().println("Ciasteczka są usunięte");


    }
}