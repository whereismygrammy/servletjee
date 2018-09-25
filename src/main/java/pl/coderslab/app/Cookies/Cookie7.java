package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie7", urlPatterns = "/rememberMe")
public class Cookie7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String checkbox = request.getParameter("rememberMe"); //Przyjmuje wartości on / null
        response.getWriter().println("Czesc " + name);

        if (checkbox.equals("on")) {
            Cookie cookie = new Cookie("user", name);
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        boolean knownUser = false;

        response.getWriter()
                .print("<html><body>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    String name = c.getValue();
                    response.getWriter().println("<p>Czesc " + name + " Twoje dane zostaly wczytane z ciasteczka</p>");
                    knownUser = true;
                }
            }
        }

        if (!knownUser) {
            response.getWriter()
                    .print("<form action='/rememberMe' method='post'>" +
                            "<p>Wpisz swoje imie</p>" +
                            "<p><input type='text' name='name'></br></p>" +
                            "<p><input type='checkbox' name='rememberMe'>Zapamietej mnie</br></p>" +
                            "<p><input type='submit'></p>");
        }

        response.getWriter()
                .print("</body></html>");
    }
}
