package model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_stock")
    private int productStock;

    public Product(String productName, double productPrice, int productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
    public Product() {
    }

    public int getProductId() {
        return productId;}
    public void setProductId(int productId) {
        this.productId = productId;}

    public String getProductName() {
        return productName;}
    public void setProductName(String productName) {
        this.productName = productName;}

    public double getProductPrice() {
        return productPrice;}
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;}

    public int getProductStock() {
        return productStock;}
    public void setProductStock(int productStock) {
        this.productStock = productStock;}

    @Override
    public String toString() {
        return "model.Product{" +
                "product_id=" + productId +
                ", product_name='" + productName + '\'' +
                ", product_price=" + productPrice +
                ", product_stock=" + productStock +
                '}';
    }
}
