package controller;

import model.Buyer;
import model.Product;
import service.BuyerService;
import service.ProductService;
import service.SaleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "sale-servlet", urlPatterns = "/sale-servlet")
public class SaleController extends HttpServlet {

    SaleService saleService = new SaleService();
    BuyerService buyerService = new BuyerService();
    ProductService productService = new ProductService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("option", request.getParameter("option"));
        session.setAttribute("equals", request.getParameter("equals"));

        if (request.getParameter("option").equals("create")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/createSale.jsp");
            List<Buyer> buyersList = buyerService.getAll();
            request.setAttribute("buyers", buyersList);
            List<Product> productsList = productService.getAll();
            request.setAttribute("products", productsList);
            dispatcher.forward(request, response);
        }

//        if(request.getParameter("option").equals("back")){
//            RequestDispatcher dispatcher = request.getRequestDispatcher(
//                    "/WEB-INF/jsp/index.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
//
    }
    private void processUpdateRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getSession().getAttribute("option").equals("create")) {
            int productId = Integer.parseInt(request.getParameter("productEquals"));
            Product p = productService.getById(productId);
            int quantity = Integer.parseInt(request.getParameter("saleQuantity"));
            int stock = p.getProductStock();
            if(quantity > 0 && quantity <= stock){
            int buyerId = Integer.parseInt(request.getParameter("buyerEquals"));
             Buyer b = buyerService.getById(buyerId);
            LocalDate date = LocalDate.parse(request.getParameter("saleDate"));
            saleService.createSale(b, p, date, quantity);
            p.setProductStock(p.getProductStock() - quantity);
            productService.updateProduct(p.getProductId(), p.getProductName(), p.getProductPrice(), p.getProductStock());
            }

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
