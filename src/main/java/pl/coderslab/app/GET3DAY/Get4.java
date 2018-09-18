package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get4", urlPatterns = "/Get4")
public class Get4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int number = Integer.parseInt(request.getParameter("number"));
            response.getWriter().print("Zostala przeslana liczba " + number + "\nJej dzielniki to");

            if (number == 0) {
                response.getWriter().println("Nie ma dzielnika");
            } else {
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        response.getWriter().print(i + ", ");
                    }
                }

            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Niepoprawna wartość");
        }

    }
}
