package pl.coderslab.app.POST3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post5", urlPatterns = "/Post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String convertionType = request.getParameter("convertionType");
        double degrees = Double.parseDouble(request.getParameter("degrees"));

        if (convertionType.equals("celcToFahr")) {
            double far = 32 + (9.0 / 5.0) * degrees;
            response.getWriter().println(degrees + " stopni Celsjusza to " + far + " stopni Farenheita");
        } else {
            double cel = (5.0 / 9.0) * (degrees - 32);
            response.getWriter().println(degrees + " stopni Farenheita to " + cel + " stopni Celsjusza");
        }
    }
}