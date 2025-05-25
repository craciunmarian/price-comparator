package com.example.price_comparator.controller;

import com.example.price_comparator.dto.DiscountedProduct;
import com.example.price_comparator.model.Discount;
import com.example.price_comparator.service.BestDiscountsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bestDiscounts")
public class BestDiscountController {
    private final BestDiscountsService discountsService;

    public BestDiscountController(BestDiscountsService discountsService){
        this.discountsService = discountsService;
    }

    @GetMapping("/list")
    public List<DiscountedProduct> getBestDiscounts(@RequestParam(defaultValue = "100") int limit){
        return discountsService.getBestDiscounts(limit);
    }

}
