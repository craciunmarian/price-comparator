package com.example.price_comparator.service;

import com.example.price_comparator.dto.DiscountedProduct;
import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.repository.PriceDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BestDiscountsService {
    private final PriceDataRepository repository;

    public BestDiscountsService(PriceDataRepository repository){
        this.repository = repository;
    }

    public List<DiscountedProduct> getBestDiscounts(int limit){
        //A list of all discounted products sorted from the highest discount to lowest
        List<Discount> discounts = repository.getDiscounts().stream()
                .sorted(Comparator.comparingDouble(Discount::getPercentage).reversed())
                .toList();

        List<Price> prices = repository.getPrices();

        //Mapping prices by their store+id and a list of price entries from different dates
        Map<String, List<Price>> priceMap = prices.stream().collect(Collectors.groupingBy(p -> p.getStore() + p.getProduct().getId()));

        List<DiscountedProduct> result = new ArrayList<>();

        //Looping through the list of discounted products
        for (Discount discount: discounts){
            List<Price> pricesList = priceMap.get(discount.getStore() + discount.getProduct().getId());

            //For each price entry check if the date is withing the discount date range
            for (Price p: pricesList){
                if (!p.getDate().isAfter(discount.getEndDate()) && !p.getDate().isBefore(discount.getStartDate())){
                    double discountedPrice = p.getPrice() * (1 - discount.getPercentage() / 100.0);
                    //Apply discount and add to the list of products with their price discounted
                    result.add(new DiscountedProduct(discount, discountedPrice, p.getCurrency(), p.getDate(), p.getProduct().getUnit(), p.getQuantity()));
                }
            }

        }
        return result.stream().limit(limit).toList();
    }

}
