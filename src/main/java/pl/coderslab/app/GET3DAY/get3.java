package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "get3", urlPatterns = "/get3")
public class get3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));

            for (int i = 1; i <= height;i++){
                for (int j = 1; j <= width; j++){
                    response.getWriter().print(i + " * " + j +  " = " + (i*j) + " | ");
                }
                response.getWriter().println("\n");
            }


        } catch (NumberFormatException e){
            e.printStackTrace();
        }



    }
}
