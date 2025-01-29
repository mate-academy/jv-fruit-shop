package core.basesyntax;

import core.basesyntax.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class CsvDataConverter implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        data.forEach(line -> {
            String[] parts = line.trim().split(",");
            if (parts.length != 3) {
                return;
            }
            String operationCode = parts[0];
            Operation operation = getOperationByCode(operationCode);
            if (operation == null) {
                return;
            }
            String fruit = parts[1].trim();
            if (fruit.isEmpty()) {
                return;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                return;
            }
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        });
        return transactions;
    }

    private Operation getOperationByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        return null;
    }
}
