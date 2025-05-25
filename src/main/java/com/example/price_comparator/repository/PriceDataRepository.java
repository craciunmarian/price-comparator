package com.example.price_comparator.repository;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PriceDataRepository implements PriceRepository{
    private final List<Price> prices = new ArrayList<>();
    private final List<Discount> discounts = new ArrayList<>();

    @Override
    public void addPrices(List<Price> entries){
        prices.addAll(entries);
    }

    @Override
    public void addDiscounts(List<Discount> entries){
        discounts.addAll(entries);
    }

    @Override
    public List<Price> getPrices(){
        return prices;
    }

    public List<Discount> getDiscounts(){
        return discounts;
    }

    @Override
    public String toString() {
        return "PriceRepositoryData{" +
                "prices=" + prices +
                ", discounts=" + discounts +
                '}';
    }
    
}
