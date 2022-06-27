package service;

import dao.BuyerDAO;
import model.Buyer;

import java.util.List;

public class BuyerService {

    BuyerDAO dao = new BuyerDAO();

    public void createBuyer(String buyerName, String buyerAddress){
        Buyer buyer = new Buyer();
        buyer.setBuyerName(buyerName);
        buyer.setBuyerAddress(buyerAddress);
        dao.createBuyer(buyer);
    }

    public void updateBuyer(int id, String buyerName, String buyerAddress){
        Buyer buyer = dao.getById(id);
        System.out.println(buyer);
        buyer.setBuyerName(buyerName);
        buyer.setBuyerAddress(buyerAddress);
        dao.updateBuyer(buyer);
    }

    public void deleteBuyer(int id){
        dao.deleteBuyer(id);
    }

    public Buyer getById(int id){
        return dao.getById(id);
    }

    public List<Buyer> getAll(){
        return dao.getAllBuyers();
    }
}
