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

        try {
            int year = Integer.parseInt(request.getParameter("year"));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
}
