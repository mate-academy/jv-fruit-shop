package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    @Override
    public List<FruitTransaction> parseFromString(List<String> transactionLine) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : transactionLine) {
            String[] parts = transaction.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid transaction format: "
                        + transactionLine);
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
