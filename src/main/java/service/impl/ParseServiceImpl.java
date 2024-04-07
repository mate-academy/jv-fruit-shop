package service.impl;

import model.FruitTransaction;
import service.ParseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    List<FruitTransaction> parsedData;
    List<String> transactions;

    @Override
    public List<FruitTransaction> parseFromString(List<String> transactionStr) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : transactionStr) {
            String[] parts = transaction.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid transaction format: " + transactionStr);
            }
            FruitTransaction.Operation operationCode =
                    FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            parsedData.add(new FruitTransaction(operationCode, fruit, quantity));
        }
        return parsedData;
    }
}
