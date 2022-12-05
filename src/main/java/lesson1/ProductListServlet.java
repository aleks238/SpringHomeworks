package lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductListServlet", urlPatterns = "/list")
public class ProductListServlet extends HttpServlet {
    private Product[] products;
    private static final int size = 10;

    @Override
    public void init() throws ServletException {
        products = new Product[size];
        for (int i = 0; i < 10; i++) {
            int index = i + 1;
            products[i] = new Product(index, "продукт" + index, index);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        for (Product product : products) {
            out.println("<html><body><h2>" + String.format("%d %s %.2f %n", product.getId(), product.getTitle(), product.getCost()) +"</h2></body></html>");
        }
        out.close();
    }
}
