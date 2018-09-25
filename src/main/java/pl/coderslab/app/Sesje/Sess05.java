package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Sess05", urlPatterns = "/Sess05")
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String mail = request.getParameter("mail");
        int captchaStr = Integer.parseInt(request.getParameter("captcha"));

        HttpSession session = request.getSession();
        int countCaptcha = (Integer) session.getAttribute("countCaptcha");


        if (captchaStr == countCaptcha) {
            response.getWriter().print(firstname + ' ' + lastname + ' ' + mail + ' ' + captchaStr);
        } else {
            response.getWriter().print("Zla kapcza");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random r = new Random();
        int num1 = r.nextInt(101);
        int num2 = r.nextInt(101);

        response.getWriter().print("" +
                "<html><body>" +
                "<form action='#' method='post'>" +
                "<p>Imie<br> <input type=\"text\" name=\"firstname\"><br></p>" +
                "<p>Nazwisko<br> <input type=\"text\" name=\"lastname\"><br></p>" +
                "<p>Mail<br> <input type=\"email\" name=\"mail\"><br></p>" +
                "<p>Wpisz ponizej sume " + num1 + " + " + num2 + "<br> <input type=\"number\" name=\"captcha\"><br></p>" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>" +
                "</body></html>");

        HttpSession session = request.getSession();
        session.setAttribute("countCaptcha", (num1 + num2));

    }
}
