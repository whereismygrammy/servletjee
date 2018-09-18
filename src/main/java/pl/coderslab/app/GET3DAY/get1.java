package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "get1", urlPatterns = "/get1")
public class get1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");

        if (startStr != null && endStr != null) {
            try {
                int start = Integer.parseInt(startStr);
                int end = Integer.parseInt(endStr);

                for (int i = start; i <= end; i++) {
                    response.getWriter().println(i);
                }

            } catch (NumberFormatException e) {
                response.getWriter().println("Niepoprawne dane.");
            }

        } else {
            response.getWriter().println("Brak przesłanych zmiennych.");
        }

    }
}
