package com.example.price_comparator.repository;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface PriceRepository {
    void addPrices(List<Price> entries);
    void addDiscounts(List<Discount> entries);

    List<Price> getPrices();
    List<Discount> getDiscounts();

}
