package com.example.price_comparator.service;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.model.Product;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvParse {

    public List<Price> parseStoreCsv(String store, LocalDate date, Path filePath) throws IOException, CsvValidationException{
        List<Price> entries = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath.toFile())).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build()){
            String[] line;

            while ((line = reader.readNext()) != null){
                if(line[0].equals("product_id")) continue;
                Product product = new Product();
                Price price = new Price();

                //0product_id;1product_name;2product_category;3brand;4package_quantity;5package_unit;6price;7currency
                product.setId(line[0]);
                product.setName(line[1]);
                product.setCategory(line[2]);
                product.setBrand(line[3]);
                product.setUnit(line[5]);

                price.setStore(store);
                price.setProduct(product);
                price.setPrice(Double.parseDouble(line[6]));
                price.setCurrency(line[7]);
                price.setDate(date);
                price.setQuantity(Double.parseDouble(line[4]));

                entries.add(price);
            }
        }
        return entries;
    }

    public List<Discount> parseDiscountCsv(String store,LocalDate date, Path filePath) throws IOException, CsvValidationException {
        List<Discount> entries = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath.toFile())).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build()){
            String[] line;

            while ((line = reader.readNext()) != null) {
                if(line[0].equals("product_id")) continue;
                Product product = new Product();
                Discount discount = new Discount();

                //0product_id;1product_name;2brand;3package_quantity;4package_unit;5product_category;6from_date;7to_date;8percentage_of_discount
                product.setId(line[0]);
                product.setName(line[1]);
                product.setBrand(line[2]);
                product.setUnit(line[4]);
                product.setCategory(line[5]);

                discount.setProduct(product);
                discount.setStore(store);
                discount.setDate(date);
                discount.setStartDate(LocalDate.parse(line[6]));
                discount.setEndDate(LocalDate.parse(line[7]));
                discount.setPercentage(Double.parseDouble(line[8]));

                entries.add(discount);
            }
        }
        return entries;
    }
}
