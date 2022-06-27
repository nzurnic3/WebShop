package controller;

import model.Buyer;
import service.BuyerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "buyer-servlet", urlPatterns = "/buyer-servlet")
public class BuyerController extends HttpServlet {

    BuyerService buyerService = new BuyerService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("option", request.getParameter("option"));
        session.setAttribute("equals", request.getParameter("equals"));

        if(request.getParameter("option").equals("create")){
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/createBuyer.jsp");
        dispatcher.forward(request, response);
        }

        if(request.getParameter("option").equals("update")) {
            Buyer buyer = buyerService.getById(Integer.parseInt(request.getParameter("equals")));
            request.setAttribute("buyer", buyer);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/createBuyer.jsp");
            dispatcher.forward(request, response);
        }

        if(request.getParameter("option").equals("delete")) {
            Buyer buyer = buyerService.getById(Integer.parseInt(request.getParameter("equals")));
            request.setAttribute("buyer", buyer);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/deleteBuyer.jsp");
            dispatcher.forward(request, response);
        }
//        if(request.getParameter("option").equals("back")){
//            RequestDispatcher dispatcher = request.getRequestDispatcher(
//                    "/WEB-INF/jsp/index.jsp");
//            dispatcher.forward(request, response);
//        }
    }

    private void processUpdateRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         if(request.getSession().getAttribute("option").equals("create")) {
            buyerService.createBuyer(request.getParameter("buyerName"),
                    request.getParameter("buyerAddress"));
         }
         else if(request.getSession().getAttribute("option").equals("update")) {
            buyerService.updateBuyer(Integer.parseInt(request.getParameter("buyerId")),
                    request.getParameter("buyerName"),
                    request.getParameter("buyerAddress"));

         }
         else if(request.getSession().getAttribute("option").equals("delete")) {
            buyerService.deleteBuyer(Integer.parseInt(request.getParameter("buyerId")));

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
