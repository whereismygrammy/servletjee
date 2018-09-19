package pl.coderslab.app.POST3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Post4", urlPatterns = "/Post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] numbersStr = request.getParameterValues("numbers");
        List<Integer> intList = new ArrayList<>();

        for (String s : numbersStr) {
            try {
                int temp = Integer.parseInt(s);
                intList.add(temp);
            } catch (NumberFormatException e) {
                System.out.println("Nic nie moglismy zrobic :(");
            }
        }

        Collections.sort(intList);
        for (Integer i : intList) {
            response.getWriter().println(i);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rn = new Random();
        int max = 10;
        int min = 5;
        int size = rn.nextInt((max - min) + 1) + min;

        response.getWriter().println("<html><body><form action=\"/Post4\" method=\"post\">\n");

        for (int i = 1; i <= size; i++) {
            response.getWriter().println("<p><input type=\"number\" name=\"numbers\"> " + i + "<br></p>\n");
        }
        response.getWriter().println("<input type=\"submit\" value=\"Submit\"></form></body></html>");
    }
}
