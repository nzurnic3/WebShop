package controller;

import model.Buyer;
import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "product-servlet", urlPatterns = "/product-servlet")
public class ProductController extends HttpServlet {

    ProductService productService = new ProductService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("option", request.getParameter("option"));
        session.setAttribute("equals", request.getParameter("equals"));

        if(request.getParameter("option").equals("create")){
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/createProduct.jsp");
            dispatcher.forward(request, response);
        }

        if(request.getParameter("option").equals("update")) {
            Product product = productService.getById(Integer.parseInt(request.getParameter("equals")));
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/createProduct.jsp");
            dispatcher.forward(request, response);
        }

        if(request.getParameter("option").equals("delete")) {
            Product product = productService.getById(Integer.parseInt(request.getParameter("equals")));
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/deleteProduct.jsp");
            dispatcher.forward(request, response);
        }
        if(request.getParameter("option").equals("back")){
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void processUpdateRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getSession().getAttribute("option").equals("create")) {
            productService.createProduct(request.getParameter("productName"),
                    Double.parseDouble((request.getParameter("productPrice"))),
                    Integer.parseInt(request.getParameter("productStock")));
        }
        else if(request.getSession().getAttribute("option").equals("update")) {
            productService.updateProduct(Integer.parseInt(request.getParameter("productId")),
                    request.getParameter("productName"),
                    Double.parseDouble((request.getParameter("productPrice"))),
                    Integer.parseInt(request.getParameter("productStock")));
        }
        else if(request.getSession().getAttribute("option").equals("delete")) {
            productService.deleteProduct(Integer.parseInt(request.getParameter("productId")));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processUpdateRequest(request, response);

    }
}
