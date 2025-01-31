package service;

import dao.TransactionsDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class CsvProcessor {
    private final TransactionsDao transactionsDao;

    public CsvProcessor(TransactionsDao transactionsDao) {
        this.transactionsDao = transactionsDao;
    }

    public void processCsv(String filePath) {
        List<FruitTransaction> transactions = readTransactionsFromCsv(filePath);
        transactions.forEach(transactionsDao::processTransaction);
    }

    private List<FruitTransaction> readTransactionsFromCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .skip(1) // Skip header
                    .map(this::parseTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }
    }

    private FruitTransaction parseTransaction(String line) {
        int fruitNameIndex = 1;
        int quantityIndex = 2;
        int operationTypeIndex = 0;
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV format: " + line);
        }
        return new FruitTransaction(
                parts[fruitNameIndex],
                Integer.parseInt(parts[quantityIndex]),
                FruitTransaction.Operation.fromCode(parts[operationTypeIndex]));
    }
}
