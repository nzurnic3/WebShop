package model;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private int buyerId;
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "buyer_address")
    private String buyerAddress;

    public Buyer(String buyerName, String buyerAddress) {
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
    }
    public Buyer() {
    }

    public int getBuyerId() {
        return buyerId;}
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;}

    public String getBuyerName() {
        return buyerName;}
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;}

    public String getBuyerAddress() {
        return buyerAddress;}
    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;}

    @Override
    public String toString() {
        return "model.Buyer{" +
                "buyer_id=" + buyerId +
                ", buyer_name='" + buyerName + '\'' +
                ", buyer_address='" + buyerAddress + '\'' +
                '}';
    }
}
