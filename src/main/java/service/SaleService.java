package service;

import dao.SaleDAO;
import model.Buyer;
import model.Product;
import model.Sale;

import java.time.LocalDate;
import java.util.List;

public class SaleService {

    SaleDAO dao = new SaleDAO();

    public void createSale(Buyer buyer, Product product, LocalDate saleDate, int saleQuantity){
        Sale sale = new Sale();
        sale.setBuyer(buyer);
        sale.setProduct(product);
        sale.setSaleDate(saleDate);
        sale.setSaleQuantity(saleQuantity);
        sale.setTotalPrice(saleQuantity * product.getProductPrice());
        dao.createSale(sale);
    }

    public List<Sale> getAll(){
        return dao.getAllSales();
    }
}
