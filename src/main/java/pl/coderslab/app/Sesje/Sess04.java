package pl.coderslab.app.Sesje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "Sess04", urlPatterns = "/Sess04")
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String[][] productsList = null;

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String[] product = {name, quantity, price};

        try {
            if (session.getAttribute("productsList") != null) {
                productsList = (String[][]) session.getAttribute("productsList");
                productsList = Arrays.copyOf(productsList, productsList.length + 1);
                productsList[productsList.length - 1] = product;

            } else {
                productsList = new String[1][];
                productsList[0] = product;
            }

            session.setAttribute("productsList", productsList);

            printProducts(response, productsList);

        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[][] productsList = null;

        try {
            if (session.getAttribute("productsList") != null) {
                productsList = (String[][]) session.getAttribute("productsList");
                printProducts(response, productsList);
            } else {
                response.getWriter().print("Brak produktow w koszyku");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printProducts(HttpServletResponse response, String[][] productsList) throws IOException {
        double sum = 0;
        response.getWriter().print("" +
                "<!DOCTYPE html><html><body>\n" +
                "<table width = 300px>");

        for (String[] strings : productsList) {
            int quant = Integer.parseInt(strings[1]);
            double pric = Double.parseDouble(strings[2]);
            double priceForManyItems = quant * pric;
            sum = sum + priceForManyItems;
            response.getWriter().print("<tr><td>" + strings[0] + "</td><td> - </td><td>" + quant + "</td><td> x </td><td>" + pric + "</td>" +
                    "<td> = </td><td>" + priceForManyItems + "</td></tr>");
        }
        response.getWriter().print("<tr><td>" + "</td><td>  </td><td>" + "</td><td>  </td><td>" + "</td>" +
                "<td> SUMA: </td><td>" + sum + "</td></tr>");
        response.getWriter().print("</table></body></html>");

    }

}
