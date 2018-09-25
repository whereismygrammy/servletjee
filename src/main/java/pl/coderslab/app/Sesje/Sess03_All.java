package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Sess03_All", urlPatterns = "/showAllSession")
public class Sess03_All extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        response.getWriter().println("<!DOCTYPE html><html><body>\n" +
                "<h2>Zmienne sesyjne</h2>\n" +
                "<table width = 200px>");

        try {
            ArrayList<String> listOfAtributes = (ArrayList<String>) session.getAttribute("listOfAtributes");
            if (listOfAtributes != null) {

                response.getWriter().println("<tr><th>Key</th><th>Value</th></tr>");
                for (String key : listOfAtributes) {
                    String value = (String) session.getAttribute(key);
                    response.getWriter().println("<tr><td>" + key + "</td><td>" + value + "</td></tr>\n");
                }
            } else {
                response.getWriter().println("Nie ma atrybutów sesyjnych");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        response.getWriter().println("" +
                "</table>\n" +
                "</body></html>");


    }
}
