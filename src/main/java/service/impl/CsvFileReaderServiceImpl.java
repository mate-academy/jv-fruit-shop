package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.CsvFileReaderService;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String SEPARATOR = ",";
    private static final int ACTIVITY_CODE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(SEPARATOR);
                String operationCode = values[ACTIVITY_CODE].trim();
                String fruit = values[FRUIT_NAME].trim();
                int quantity = Integer.parseInt(values[FRUIT_QUANTITY].trim());

                FruitTransaction.Operation operation = null;
                for (FruitTransaction.Operation fruitOperation
                        : FruitTransaction.Operation.values()) {
                    if (fruitOperation.getCode().equals(operationCode)) {
                        operation = fruitOperation;
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
