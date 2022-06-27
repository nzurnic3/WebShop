package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductService {

    ProductDAO dao = new ProductDAO();


    public Product getById(int id) {
        return dao.getById(id);
    }

    public void createProduct(String productName, double productPrice, int productStock) {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductStock(productStock);
        dao.createProduct(product);
    }

    public void updateProduct(int id, String productName, double productPrice, int productStock) {
        Product product = dao.getById(id);
        System.out.println(product);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductStock(productStock);
        dao.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        dao.deleteProduct(productId);
    }

    public List<Product> getAll() {
        return dao.getAllProducts();
    }
}
