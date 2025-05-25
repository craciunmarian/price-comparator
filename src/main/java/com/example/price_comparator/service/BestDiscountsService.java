package com.example.price_comparator.service;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.repository.PriceDataRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestDiscountsService {
    private final PriceDataRepository repository;

    public BestDiscountsService(PriceDataRepository repository){
        this.repository = repository;
    }

    public List<Discount> getBestDiscounts(int limit){
        return repository.getDiscounts().stream()
                .sorted(Comparator.comparingDouble(Discount::getPercentage).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

}
