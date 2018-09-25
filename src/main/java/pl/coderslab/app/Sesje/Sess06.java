package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@WebServlet(name = "Sess06", urlPatterns = "/Sess06")
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int add = Integer.parseInt(request.getParameter("add"));
        int min = Integer.parseInt(request.getParameter("min"));
        int mul = Integer.parseInt(request.getParameter("mul"));

        HttpSession session = request.getSession();
        int num1FromSession = (int) session.getAttribute("num1");
        int num2FromSession = (int) session.getAttribute("num2");

        int addTrue = num1FromSession + num2FromSession;
        int minTrue = num1FromSession - num2FromSession;
        int mulTrue = num1FromSession * num2FromSession;

        String addString = "Wrong";
        String minString = "Wrong";
        String mulString = "Wrong";

        if (add == addTrue) {
            addString = "Correct";
        }

        if (min == minTrue) {
            minString = "Correct";
        }

        if (mul == mulTrue) {
            mulString = "Correct";
        }

        response.getWriter().print("<html><body>");
        response.getWriter().print("<table>");
        response.getWriter().print("<tr><td>" + num1FromSession + "</td><td> + </td><td>" + num2FromSession + "<td> <td> = </td> <td>" + add + "</td> <td>" + addString + "</td></tr>");
        response.getWriter().print("<tr><td>" + num1FromSession + "</td><td> - </td><td>" + num2FromSession + "<td> <td> = </td> <td>" + min + "</td> <td>" + minString + "</td></tr>");
        response.getWriter().print("<tr><td>" + num1FromSession + "</td><td> * </td><td>" + num2FromSession + "<td> <td> = </td> <td>" + mul + "</td> <td>" + mulString + "</td></tr>");
        response.getWriter().print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random r = new Random();
        ArrayList<Integer> ar = new ArrayList<>();
        int num1 = r.nextInt(101 - 20) + 20;
        int num2 = r.nextInt(101 - 20) + 20;

        HttpSession session = request.getSession();

        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        response.getWriter().print("<html><body>");

        response.getWriter().print("<p>Numery to " + num1 + " i " + num2 + "</p>");
        response.getWriter().print("<form action='#' method='post'>");
        response.getWriter().print("<p>Dodaj liczby </br> <input type='number' name='add'></p>");
        response.getWriter().print("<p>Odejmij liczby </br> <input type='number' name='min'></p>");
        response.getWriter().print("<p>Pomoz liczby </br> <input type='number' name='mul'></p>");
        response.getWriter().print("<p><input type='submit'</p>");

        response.getWriter().print("</body></html>");
    }
}



