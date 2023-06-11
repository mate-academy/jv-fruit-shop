package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements FruitTransactionReader {
    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(data[0].toUpperCase());
                String fruit = data[1];
                int quantity = Integer.parseInt(data[2]);

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file: " + filePath, e);
        }

        return transactions;
    }
}
