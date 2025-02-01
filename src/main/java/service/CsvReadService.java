package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class CsvReadService implements Reader {
    private final CsvParseService csvParseService;

    public CsvReadService(CsvParseService csvParseService) {
        this.csvParseService = csvParseService;
    }

    @Override
    public List<FruitTransaction> readTransactionsFromCsv(String fileName) {
        String filePath = Paths.get("src", "main", "resources", fileName).toString();;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .skip(1) // Skip header
                    .map(csvParseService::parseTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }
    }
}
