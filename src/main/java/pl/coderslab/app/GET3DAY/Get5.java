package pl.coderslab.app.GET3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "Get5", urlPatterns = "/Get5")
public class Get5 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            response.getWriter().println(entry.getKey());
            String[] tempStringArray = entry.getValue();

            for (int i = 0; i < tempStringArray.length; i++) {
                response.getWriter().println(" - " + tempStringArray[i]);
            }
        }
    }
}
