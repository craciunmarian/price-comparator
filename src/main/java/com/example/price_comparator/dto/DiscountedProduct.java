package com.example.price_comparator.dto;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Product;

import java.time.LocalDate;

public class DiscountedProduct {
    private Discount discount;
    private double discountedPrice;
    private String currency;
    private LocalDate date;
    private String unit;
    private double quantity;
    private String valuePerUnit;

    public DiscountedProduct(Discount discount, double discountedPrice, String currency, LocalDate date, String unit, double quantity) {
        this.discount = discount;
        this.discountedPrice = discountedPrice;
        this.currency = currency;
        this.date = date;
        this.unit = unit;
        this.quantity = quantity;
        this.valuePerUnit = String.format("%.2f", discountedPrice/quantity) + " " + currency + "/" + unit;

    }

    public LocalDate getDate() {
        return date;
    }

    public Discount getDiscount() {
        return discount;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getValuePerUnit() {
        return valuePerUnit;
    }
}
