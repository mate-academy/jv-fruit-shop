package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertService;

import java.util.ArrayList;
import java.util.List;

public class DataConvertServiceImpl implements DataConvertService {
    @Override
    public List<FruitTransaction> convertTransactions(List<String> lines) {
        List<FruitTransaction> list = new ArrayList<>();
        if (!lines.isEmpty()) {
            for (int i = 1; i <lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new RuntimeException("Incorrect data format in line: " + (i + 1) + ". Expected 3 parts.");
                }
                String operationCode = parts[0].trim();
                FruitTransaction.Operation operation;
                try {
                    operation = FruitTransaction.Operation.getOperationByCode(operationCode);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Unknown operation code " + operationCode);
                }
                String fruit = parts[1].trim();
                String strQuantity = parts[2].trim();
                int quantity;
                try {
                    quantity = Integer.parseInt(strQuantity);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Incorrect quantity format: " + strQuantity);
                }
                FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
                list.add(fruitTransaction);
            }
        }
        return list;
    }
}
