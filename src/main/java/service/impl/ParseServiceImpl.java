package service.impl;

import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    @Override
    public FruitTransaction parseFromString(String transactionStr) {
        String[] parts = transactionStr.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid transaction format: " + transactionStr);
        }

        FruitTransaction.Operation operationCode =
                FruitTransaction.Operation.fromCode(parts[0]);
//                FruitTransaction.Operation.fromCode(parts[0]);
        String fruit = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        return new FruitTransaction(operationCode, fruit, quantity);
    }
}
