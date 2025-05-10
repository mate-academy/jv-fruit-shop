package core.basesyntax.service.impl;

import static core.basesyntax.Main.COMMA_SEPARATOR;

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
            String[] parts = line.split(COMMA_SEPARATOR);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid data format: " + line);
            }
            String operationCode = parts[0];
            Operation operation;
            operation = Operation.getOperationByCode(operationCode);
            String fruit = parts[1];
            if (fruit.isEmpty()) {
                throw new IllegalArgumentException(
                        "Invalid data format. Fruit must not be empty: " + line);
            }
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid data format. Provide valid fruits quantity: " + line);
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
