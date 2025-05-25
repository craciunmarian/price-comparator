package com.example.price_comparator.controller;

import com.example.price_comparator.dto.DiscountedProduct;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.service.ProductListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductListController {
    private final ProductListService productListService;

    public ProductListController(ProductListService productListService) {
        this.productListService = productListService;
    }

    @GetMapping("/list")
    public List<Price> getBestDiscounts(@RequestParam(defaultValue = "100") int limit){
        return productListService.getPriceList(limit);
    }

}
