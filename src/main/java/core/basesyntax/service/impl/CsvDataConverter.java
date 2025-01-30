package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.FruitTransaction.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class CsvDataConverter implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.trim().split(",");
            if (parts.length != 3) {
                continue;
            }
            String operationCode = parts[0];
            Operation operation;
            try {
                operation = Operation.getOperationByCode(operationCode);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            String fruit = parts[1].trim();
            if (fruit.isEmpty()) {
                continue;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                continue;
            }
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
