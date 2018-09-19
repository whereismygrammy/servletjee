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

@WebServlet(name = "Sess02", urlPatterns = "/Sess02")
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        List<Integer> grades = (List<Integer>) session.getAttribute("grades");
        if (grades == null) {
            grades = new ArrayList<>();
        }

        response.setContentType("text/html");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='number' name='grade'>");
        response.getWriter().println("<input type='submit'>");
        response.getWriter().println("</form>");


        //Calculate
        String gradeStr = request.getParameter("grade");
        Integer grade = null;

        try {
            grade = Integer.parseInt(gradeStr);
            if (grade > 0 && grade < 7) {
                grades.add(grade);
                session.setAttribute("grades", grades);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Display avg
        response.getWriter().println(grades.toString());


        if (grades.size() > 0) {
            double sum = 0.0;
            for (int element : grades) {
                sum += element;
            }
            double avg = sum / grades.size();
            response.getWriter().println("avg=" + avg);
        } else {
            response.getWriter().println("Brak danych");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='number' name='grade'>");
        response.getWriter().println("<input type='submit'>");
        response.getWriter().println("</form>");

    }
}
