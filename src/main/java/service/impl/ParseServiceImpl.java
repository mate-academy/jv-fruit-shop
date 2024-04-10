package service.impl;

import model.FruitTransaction;
import service.ParseService;

import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    List<FruitTransaction> parsedData;
    List<String> transactions;

    @Override
    public List<FruitTransaction> parseFromString(List<String> transactionLine) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : transactionLine) {
            String[] parts = transaction.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid transaction format: " + transactionLine);
            }
            FruitTransaction.Operation operationType =
                    FruitTransaction.Operation.getNameOfType(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            parsedData.add(new FruitTransaction(operationType, fruit, quantity));
        }
        return parsedData;
    }
}
