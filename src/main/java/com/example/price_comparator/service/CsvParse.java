package com.example.price_comparator.service;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.model.Product;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvParse {

    public List<Price> parseStoreCsv(String store, LocalDate date, Path filePath) throws IOException, CsvValidationException{
        List<Price> entries = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath.toFile()))){
            String[] line;

            while ((line = reader.readNext()) != null){
                Product product = new Product();
                Price price = new Price();

                //0product_id;1product_name;2product_category;3brand;4package_quantity;5package_unit;6price;7currency
                product.setId(line[0]);
                product.setName(line[1]);
                product.setCategory(line[2]);
                product.setBrand(line[3]);
                product.setUnit(line[5]);

                price.setStore(store);
                price.setPrice(Double.parseDouble(line[6]));
                price.setCurrency(line[7]);
                price.setDate(date);
                price.setQuantity(Double.parseDouble(line[4]));

                entries.add(price);
            }
        }
        return entries;
    }

    public List<Discount> parseDiscountCsv(String store, LocalDate date, Path filePath) throws IOException, CsvValidationException{
        List<Discount> entries = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath.toFile()))){
            String[] line;

            while ((line = reader.readNext()) != null) {

            }
    }


}
