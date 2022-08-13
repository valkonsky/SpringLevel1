package ru.gb.savilin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/products/*")
public class MainServlet extends HttpServlet {

    private ProductRepository productManager;
    private static final Pattern PARAM_PATTERN = Pattern.compile("\\/(\\d+)");

    @Override
    public void init() throws ServletException {
        productManager = new ProductRepository();
        productManager.insert(new Product("cap",3000));
        productManager.insert(new Product("car",3000000));
        productManager.insert(new Product("bag",2000));
        productManager.insert(new Product("book",390));
        productManager.insert(new Product("shave foam",200));
        productManager.insert(new Product("lamp",1500));
        productManager.insert(new Product("table",15000));
        productManager.insert(new Product("snickers",12000));
        productManager.insert(new Product("jacket",9000));
        productManager.insert(new Product("jeans",11000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")){
            resp.getWriter().println( "<table border = 1>");
            resp.getWriter().println( "<tr>");
            resp.getWriter().println( "<th>id</th>");
            resp.getWriter().println( "<th>title</th>");
            resp.getWriter().println( "<th>cost</th>");
            resp.getWriter().println( "</tr>");
            for (Product product : productManager.findAll()){
                resp.getWriter().println( "<tr>");
                resp.getWriter().println( "<td> <a href= '" + product.getId() + "'>" + product.getId() +"</td>");
                resp.getWriter().println( "<td>" + product.getTitle() + "</td>");
                resp.getWriter().println( "<td>" + product.getCost() + "</td>");
                resp.getWriter().println( "</tr>");
            }
            resp.getWriter().println("</table>");
        }else{
            Matcher matcher = PARAM_PATTERN.matcher(req.getPathInfo());
            if (matcher.matches()){
                Long id = Long.parseLong(matcher.group(1));
                Product product = productManager.getById(id);
                if (product == null) {
                    resp.getWriter().println("user not found");
                    return;
                }else {
                    resp.getWriter().println("<table border = 1>");
                    resp.getWriter().println("<tr>");
                    resp.getWriter().println("<th>id</th>");
                    resp.getWriter().println("<th>title</th>");
                    resp.getWriter().println("<th>cost</th>");
                    resp.getWriter().println("</tr>");
                    resp.getWriter().println("<tr>");
                    resp.getWriter().println("<td>" + product.getId() + "</td>");
                    resp.getWriter().println("<td>" + product.getTitle() + "</td>");
                    resp.getWriter().println("<td>" + product.getCost() + "</td>");
                    resp.getWriter().println("</tr>");
                    resp.getWriter().println("</table>");
                }

            }else{
                resp.getWriter().println("Bad parameter value");
            }
        }
    }
}
