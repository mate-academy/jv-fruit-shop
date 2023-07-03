package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.CsvFileReaderService;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");
                String operationCode = values[0].trim();
                String fruit = values[1].trim();
                int quantity = Integer.parseInt(values[2].trim());

                FruitTransaction.Operation operation = null;
                for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
                    if (op.getCode().equals(operationCode)) {
                        operation = op;
                        break;
                    }
                }

                if (operation == null) {
                    throw new IllegalArgumentException("Invalid operation code: " + operationCode);
                }
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + filePath, e);
        }

        return transactions;
    }
}
