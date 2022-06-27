package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int saleId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "sale_date")
    private LocalDate saleDate;
    @Column(name = "sale_quantity")
    private int saleQuantity;
    @Column(name = "total_price")
    private double totalPrice;

    public Sale(LocalDate saleDate, int saleQuantity, double totalPrice) {
        this.saleDate = saleDate;
        this.saleQuantity = saleQuantity;
        this.totalPrice = totalPrice;
    }

    public Sale() {
    }

    public int getSaleId() {
        return saleId;}
    public void setSaleId(int saleId) {
        this.saleId = saleId;}

    public LocalDate getSaleDate() {
        return saleDate;}
    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;}

    public int getSaleQuantity() {
        return saleQuantity;}
    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;}

    public double getTotalPrice() {
        return totalPrice;}
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;}

    public Buyer getBuyer() {
        return buyer;}
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;}

    public Product getProduct() {
        return product;}
    public void setProduct(Product product) {
        this.product = product;}

    @Override
    public String toString() {
        return "model.Sale{" +
                "sale_id=" + saleId +
                ", sale_date=" + saleDate +
                ", sale_quantity=" + saleQuantity +
                ", total_price=" + totalPrice +
                '}';
    }
}
