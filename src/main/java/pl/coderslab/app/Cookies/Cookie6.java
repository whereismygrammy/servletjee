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

        System.out.println(textColor);
        System.out.println(backgroundColor);

        Cookie textColorCookie = new Cookie("textColor", textColor);
        textColorCookie.setMaxAge(3600);
        textColorCookie.setPath("/");
        response.addCookie(textColorCookie);

        Cookie backgroundColorCookie = new Cookie("backgroundColor", backgroundColor);
        backgroundColorCookie.setMaxAge(3600);
        backgroundColorCookie.setPath("/");
        response.addCookie(backgroundColorCookie);

        if (textColor.equals("") || backgroundColor.equals("")) {
            response.getWriter().println("" +
                    "<!DOCTYPE html>\n" +
                    "<html><body>" +
                    "<h1>Wybiersz sobie oba kolory! <a href=\"/indexCookie6.html\">tutaj</a></h>" +
                    "</body></html>");

        } else {
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


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textColor = "";
        String backgroundColor = "";


        Cookie[] cookies = request.getCookies();

        System.out.println(cookies);

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("textColor")) {
                    textColor = c.getValue();
                }
                if (c.getName().equals("backgroundColor")) {
                    backgroundColor = c.getValue();
                }
            }
        }


        if (textColor.equals("") || backgroundColor.equals("")) {
            response.getWriter().println("" +
                    "<!DOCTYPE html>\n" +
                    "<html><body>" +
                    "<h1>Wybiersz sobie oba kolory! <a href=\"/indexCookie6.html\">tutaj</a></h>" +
                    "</body></html>");

        } else {
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


}

