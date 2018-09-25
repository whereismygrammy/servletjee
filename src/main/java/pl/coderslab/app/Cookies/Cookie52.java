package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie52", urlPatterns = "/Cookie52")
public class Cookie52 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String welcome = "<a href =\"/Cookie51\">Nie odwiedziles jeszcze 51</a>";

        try {
            Cookie[] requestCookies = request.getCookies();
            for (Cookie c : requestCookies) {
                if (c.getName().equals("visit51") && c.getValue().equals("true")) {
                    welcome = "Witamy na stronie Cookie52";
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        response.getWriter().println(welcome);

    }
}
