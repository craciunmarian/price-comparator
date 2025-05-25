package com.example.price_comparator.controller;

import com.example.price_comparator.model.Price;
import com.example.price_comparator.service.PriceHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price-history")
public class PriceHistoryController {
    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }

    @GetMapping("/{id}")
    public List<Price> getPriceHistory(@PathVariable String id){
        return priceHistoryService.getPriceHistory(id);
    }

}
