package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = "/Get62")
public class Get62 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random r = new Random();
        int max = 10;
        int min = -10;


        try {
            int year = Integer.parseInt(request.getParameter("year"));

            for (int i = 1; i < 6; i++) {
                int number = r.nextInt(max + 1 - min) + min;
                response.getWriter().println("<a href=\"/Get63?year=" + year + "&mix=" + number + "\">Rok "+ year + ", mix " + number + "</a></br>");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
