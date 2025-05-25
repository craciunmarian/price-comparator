package com.example.price_comparator.service;

import com.example.price_comparator.model.Price;
import com.example.price_comparator.repository.PriceDataRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PriceHistoryService {
    private final PriceDataRepository repository;

    public PriceHistoryService(PriceDataRepository repository) {
        this.repository = repository;
    }


    //Methods to show price history by id filterable by store, category, brand
    public List<Price> getPriceHistory(String id){
        return repository.getPrices().stream()
                .filter(p -> p.getProduct().getId().equals(id)).sorted(Comparator.comparing(Price::getDate)).toList();
    }

    public List<Price> getPriceHistoryByStore(String store, String id){
        return repository.getPrices().stream()
                .filter(p -> p.getStore().equals(store) && p.getProduct().getId().equals(id)).sorted(Comparator.comparing(Price::getDate)).toList();
    }

    public List<Price> getPriceHistoryByBrand(String brand, String id){
        return repository.getPrices().stream()
                .filter(p -> p.getProduct().getBrand().equals(brand) && p.getProduct().getId().equals(id)).sorted(Comparator.comparing(Price::getDate)).toList();
    }

    public List<Price> getPriceHistoryByCategory(String category, String id){
        return repository.getPrices().stream()
                .filter(p -> p.getProduct().getCategory().equals(category) && p.getProduct().getId().equals(id)).sorted(Comparator.comparing(Price::getDate)).toList();
    }

}
