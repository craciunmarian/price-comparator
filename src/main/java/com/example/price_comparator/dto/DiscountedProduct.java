package com.example.price_comparator.dto;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Product;

import java.time.LocalDate;

public class DiscountedProduct {
    private Discount discount;
    private double discountedPrice;
    private String currency;
    private LocalDate date;

    public DiscountedProduct(Discount discount, double discountedPrice, String currency, LocalDate date) {
        this.discount = discount;
        this.discountedPrice = discountedPrice;
        this.currency = currency;
        this.date = date;
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
}
