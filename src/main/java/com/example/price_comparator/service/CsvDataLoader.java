package com.example.price_comparator.service;

import com.example.price_comparator.model.Discount;
import com.example.price_comparator.model.Price;
import com.example.price_comparator.repository.PriceDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Component
public class CsvDataLoader implements CommandLineRunner {

    private final CsvParse csvParse;
    private final PriceDataRepository repository;

    private final Path directory = Paths.get("src/main/resources/csv");

    public CsvDataLoader(CsvParse csvParse, PriceDataRepository repository) {
        this.csvParse = csvParse;
        this.repository = repository;
    }

    public void run(String... args) throws Exception{
        if (!Files.exists(directory)) {
            System.err.println("Empty directory");
            return;
        }

        try (DirectoryStream<Path> files = Files.newDirectoryStream(directory)){
            for (Path file: files){
                String fileName = file.getFileName().toString();

                if (fileName.matches("[a-zA-Z]+_\\d{4}-\\d{2}-\\d{2}\\.csv")){
                    String store = fileName.split("_")[0];
                    LocalDate date = LocalDate.parse(fileName.split("_")[1].split("\\.")[0]);
                    List<Price> prices = csvParse.parseStoreCsv(store, date, file);
                    repository.addPrices(prices);
                }
                else if (fileName.matches(".+_discount.*\\.csv")){
                    String store = fileName.split("_")[0];
                    List<Discount> discounts = csvParse.parseDiscountCsv(store, file);
                    repository.addDiscounts(discounts);
                }

            }
        } catch (IOException e){
            System.err.println("Error" + e.getMessage());
        }
    }

}
