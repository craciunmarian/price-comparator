package com.example.price_comparator;

import com.example.price_comparator.model.Price;
import com.example.price_comparator.service.CsvParse;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class CsvParseTest {
    CsvParse csvParse;

    @Test
    void testCsvParse() throws Exception{
        Path storeCsv = Paths.get("src/main/resources/csv/kaufland_2025-05-01.csv");
        String store = "Kaufland";
        LocalDate date = LocalDate.of(2024, 5, 1);

        List<Price> prices = csvParse.parseStoreCsv(store, date, storeCsv);

        prices.forEach(System.out::println);
    }


}
