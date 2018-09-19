package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Get", urlPatterns = "/showCookie")
public class Cookie1Get extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieValue = "brak ciasteczka";

        for (Cookie c : request.getCookies()) {
            if (c.getName().equals("User")) {
                cookieValue = c.getValue();
                break;
            }
        }

        response.getWriter().println("Value: " + cookieValue);
    }
}