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
        List<Discount> discounts = repository.getDiscounts().stream()
                .sorted(Comparator.comparingDouble(Discount::getPercentage).reversed())
                .toList();

        List<Price> prices = repository.getPrices();

        Map<String, List<Price>> priceMap = prices.stream().collect(Collectors.groupingBy(p -> p.getStore() + p.getProduct().getId()));

        List<DiscountedProduct> result = new ArrayList<>();

        for (Discount discount: discounts){
            List<Price> pricesList = priceMap.get(discount.getStore() + discount.getProduct().getId());

            for (Price p: pricesList){
                if(p.getProduct().getId().equals("P062")){
                    System.out.println("SD");
                }

                if (!p.getDate().isAfter(discount.getEndDate()) && !p.getDate().isBefore(discount.getStartDate())){
                    double discountedPrice = p.getPrice() * (1 - discount.getPercentage() / 100.0);
                    result.add(new DiscountedProduct(discount, discountedPrice, p.getCurrency(), p.getDate(), p.getProduct().getUnit(), p.getQuantity()));
                }
            }

        }
        return result.stream().limit(limit).toList();
    }

}
