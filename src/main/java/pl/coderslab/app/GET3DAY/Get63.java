package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get63", urlPatterns = "/Get63")
public class Get63 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int year = Integer.parseInt(request.getParameter("year"));
        int mix = Integer.parseInt(request.getParameter("mix"));
        response.getWriter().println("Rok to: " + (year + mix));

    }
}
