package com.example.price_comparator.model;

import java.time.LocalDate;

public class Price {
    private Product product;
    private String store;
    private double quantity;
    private double price;
    private String currency;
    private LocalDate date;

    public Price() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValuePerUnit() {
        if (quantity == 0) return 0;
        return price/quantity;
    }

    @Override
    public String toString() {
        return "Price{" +
                "product=" + product +
                ", store='" + store + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                '}';
    }
}
