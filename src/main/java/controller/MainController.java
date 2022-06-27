
package controller;

import model.Buyer;
import model.Product;
import model.Sale;
import service.BuyerService;
import service.ProductService;
import service.SaleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "option-servlet", urlPatterns = "/option-servlet")
public class MainController extends HttpServlet {

    private String target;


    private void processRequest(
                HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String option = request.getParameter("option");
        switch (option) {
            case "Buyer": {
                BuyerService buyerService = new BuyerService();
                List<Buyer> list = buyerService.getAll();
                target = "/WEB-INF/jsp/readBuyer.jsp";
                request.setAttribute("buyers", list);
                break;
            }
            case "Product": {
                ProductService productService = new ProductService();
                List<Product> list = productService.getAll();
                target = "/WEB-INF/jsp/readProduct.jsp";
                request.setAttribute("products", list);
                break;
            }
            case "Sale": {
                SaleService saleService = new SaleService();
                List<Sale> list = saleService.getAll();
                target = "/WEB-INF/jsp/readSale.jsp";
                request.setAttribute("sales", list);
                break;
            }
        }

            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    target);
            dispatcher.forward(request, response);
     }

        @Override
        protected void doGet(
                HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            processRequest(request, response);
        }

        @Override
        protected void doPost(
                HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            processRequest(request, response);
        }
    }
