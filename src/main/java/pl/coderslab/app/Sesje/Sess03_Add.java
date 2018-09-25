package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "Sess03_Add", urlPatterns = "/addToSession")
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> listOfAtributes = null;

        try {
            listOfAtributes = (ArrayList<String>) session.getAttribute("listOfAtributes");
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        if (listOfAtributes == null) {
            listOfAtributes = new ArrayList<>();
        }

        String key = request.getParameter("key");
        String value = request.getParameter("value");
        session.setAttribute(key, value);

        boolean addAtribute = true;
        for (String s : listOfAtributes) {
            if (s.equals(key)) {
                addAtribute = false;
            }
        }

        if (addAtribute) {
            listOfAtributes.add(key);
        }

        // TESTOWANIE
        for (String s : listOfAtributes) {
            System.out.println(s);
        }

        session.setAttribute("listOfAtributes", listOfAtributes);

        response.getWriter().println("<p><a href='/addToSession'>Dodaj zmienna sesyjna</a></br></p>");
        response.getWriter().println("<p><a href='/showAllSession'>Zobacz wszystkie zmienne sesyjne</a></p>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("<html><body><head><meta charset='utf-8'></head>" +
                "<form action=\"#\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartosc:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>" +
                "</body></html>");

    }
}
