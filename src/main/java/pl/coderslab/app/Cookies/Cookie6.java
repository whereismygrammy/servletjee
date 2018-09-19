package pl.coderslab.app.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie6", urlPatterns = "/Cookie6")
public class Cookie6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textColor = request.getParameter("textColor");
        String backgroundColor = request.getParameter("backgroundColor");

        Cookie textColorCookie = new Cookie("textColor", textColor);
        textColorCookie.setMaxAge(3600);
        textColorCookie.setPath("/");
        response.addCookie(textColorCookie);

        Cookie backgroundColorCookie = new Cookie("backgroundColor", backgroundColor);
        backgroundColorCookie.setMaxAge(3600);
        backgroundColorCookie.setPath("/");
        response.addCookie(backgroundColorCookie);

        response.getWriter().println("" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body style=\"background-color:" + backgroundColor + ";\">\n" +
                "<h1 style=\"color:" + textColor + ";\">" +
                "Wybrany kolor tekstu" + textColor + " wybrany kolor tla " + backgroundColor +
                "</h1>\n" +
                "</body>\n" +
                "</html>\n");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textColor = "black";
        String backgroundColor = "white";
        boolean cookieText = false;
        boolean cookieBack = false;

        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equals("textColor")) {
                textColor = c.getValue();
                cookieText = true;
            }
            if (c.getName().equals("backgroundColor")) {
                backgroundColor = c.getValue();
                cookieBack = true;
            }
        }

        if (cookieBack || cookieBack){
            response.getWriter().println("" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body style=\"background-color:" + backgroundColor + ";\">\n" +
                    "<h1>" +
                    "Wybierz sobie kolor <a href=\"/indexCookie6.html\">tutaj</a>" +
                    "</h1>\n" +
                    "</body>\n" +
                    "</html>\n");
        }

        response.getWriter().println("" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body style=\"background-color:" + backgroundColor + ";\">\n" +
                "<h1 style=\"color:" + textColor + ";\">" +
                "Zapamietany kolor tekstu" + textColor + " zapamietany kolor tla " + backgroundColor +
                "</h1>\n" +
                "</body>\n" +
                "</html>\n");

    }
}
