package pl.coderslab.app.POST3DAY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post2", urlPatterns = "/Post2")
public class Post2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String text = request.getParameter("text");
        String consent = request.getParameter("consent");

        if (consent==null) {
            text = doCensorText(text);
        }

        response.getWriter().println(text);

    }

    private String doCensorText(String text) {
        String[] SWEAR_WORDS = {"cholera", "kurde", "pierdolenie"};

        for (String swear : SWEAR_WORDS) {
            String stars = swear.replaceAll(".", "*");
            text = text.replaceAll(swear, stars);
        }
        return text;
    }
}
