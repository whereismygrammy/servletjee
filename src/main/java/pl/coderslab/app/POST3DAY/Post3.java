package pl.coderslab.app.POST3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post3", urlPatterns = "/Post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        double x0, x1, x2;


        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            x1 = (-b - Math.sqrt(delta)) / 2 * a;
            x2 = (-b + Math.sqrt(delta)) / 2 * a;

            response.getWriter().println("Funkcja ma 2 miejsca zerowe " + x1 + " " + x2);

        } else if (delta == 0) {
            x0 = -b / 2 * a;
            response.getWriter().println("Funkcja ma 1 miejsce zerowe " + x0);

        } else {
            response.getWriter().println("Funkcja nie ma miejsc zerowych");

        }

    }


}
