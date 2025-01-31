package service;

import dao.TransactionsDao;
import model.FruitTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvProcessService implements Processor, Reader, Parser {
    private final TransactionsDao transactionsDao;

    public CsvProcessService(TransactionsDao transactionsDao) {
        this.transactionsDao = transactionsDao;
    }

    @Override
    public void processCsv(String fileName) {
        List<FruitTransaction> transactions = readTransactionsFromCsv(fileName);
        transactions.forEach(transactionsDao::processTransaction);
    }

    @Override
    public List<FruitTransaction> readTransactionsFromCsv(String fileName) {
        String filePath = Paths.get("src", "main", "resources", fileName).toString();;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .skip(1) // Skip header
                    .map(this::parseTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }
    }

    @Override
    public FruitTransaction parseTransaction(String line) {
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
