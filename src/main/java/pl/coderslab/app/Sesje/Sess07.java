package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Sess07", urlPatterns = "/Sess07")
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[][] stateTable = createStateTable();
        HttpSession session = request.getSession();
        response.getWriter().print("<html><body>");

        String capital = (String) request.getParameter("capital");
        int countryNum = (int) session.getAttribute("countryNum");

        // Check if capital match country number - countryNum
        if (stateTable[countryNum][1].equals(capital)) {
            response.getWriter().print("<p>Dobra odpowiedz!</p>");
            int points = (int) session.getAttribute("points");
            session.setAttribute("points", points + 1);
        } else {
            response.getWriter().print("<p>Zla odpowiedz!</p>");
        }

        // Check if we have more countries
        if (countryNum < stateTable.length - 1) {

            // Increment countryNum to get next country from array
            int incrementedCountryNum = (int) session.getAttribute("countryNum") + 1;
            session.setAttribute("countryNum", incrementedCountryNum);

            // Display form for country - countryNum
            String country = stateTable[incrementedCountryNum][0];
            response.getWriter().print("<form action='#' method='post'>");
            response.getWriter().print("<p>Podaj stolice " + country + "</br> <input type='text' name='capital'></p>");
            response.getWriter().print("<p><input type='submit'</p>");
            response.getWriter().print("</body></html>");

        } else {
            int points = (int) session.getAttribute("points");
            response.getWriter().print("<p> Twoja finalna liczba punktow to " + points + "</p>");
            response.getWriter().print("<p> Spróbuj jeszcze <a href='/Sess07'>raz</a></p>");
            response.getWriter().print("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[][] stateTable = createStateTable();
        String country = stateTable[0][0];

        response.getWriter().print("<html><body>");
        response.getWriter().print("<p>" + "</p>");
        response.getWriter().print("<form action='#' method='post'>");
        response.getWriter().print("<p>Podaj stolice " + country + "</br> <input type='text' name='capital'></p>");
        response.getWriter().print("<p><input type='submit'</p>");
        response.getWriter().print("</body></html>");

        HttpSession session = request.getSession();
        session.setAttribute("countryNum", 0);
        session.setAttribute("points", 0);
    }

    private String[][] createStateTable() {
        String[][] stateTable = {
                {"Czechy", "Praga"},
                {"Slowacja", "Bratyslawa"},
                {"Ukraina", "Kijow"},
                {"Niemcy", "Berlin"},
                {"Bialorus", "Minsk"},
                {"Rosja", "Moskwa"},
                {"Litwa", "Wilno"},};
        return stateTable;
    }
}