package com.example.price_comparator.service;

import com.example.price_comparator.model.Price;
import com.example.price_comparator.repository.PriceDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductListService {
    private final PriceDataRepository repository;

    public ProductListService(PriceDataRepository repository) {
        this.repository = repository;
    }

    public List<Price> getPriceList(int limit){
        return repository.getPrices();
    }

}
