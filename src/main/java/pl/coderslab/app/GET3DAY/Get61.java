package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Get61", urlPatterns = "/Get61")
public class Get61 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random();
        int year = random.nextInt(31) + 1880;
        response.getWriter().println("<a href=\"/Get62x?year=" + year + "\">Tu pan kliknij po rok wygenerowany</a>");

    }
}
