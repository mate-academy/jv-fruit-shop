package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> convertedTransaction = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) { // Skip header
            String[] parts = data.get(i).split(",");
            if (parts.length != 3) {
                System.err.println("Skipping invalid row (not enough data): " + data.get(i));
                continue;
            }

            FruitTransaction.Operation operation;
            try {
                operation = mapOperation(parts[0]);
            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid operation code in row: " + data.get(i));
                continue;
            }

            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.err.println("Skipping row with invalid quantity (not a valid number): "
                        + data.get(i));
                continue;
            }

            convertedTransaction.add(new FruitTransaction(operation, fruit, quantity));
        }
        return convertedTransaction;
    }

    private FruitTransaction.Operation mapOperation(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Unknown operation code: " + code);
        };
    }
}
