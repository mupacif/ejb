package be.interzon.web;

import be.interzon.ejb.ProductBeanRemote;
import be.interzon.model.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class ProductServlet extends HttpServlet {
@EJB
ProductBeanRemote productBeanRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productBeanRemote.getProducts();
        System.out.println(products
        );
        PrintWriter writer = resp.getWriter();
        products.forEach((Product p)->writer.append(p.getName()).append("\n"));

        //req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
