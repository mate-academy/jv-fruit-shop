package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String HEADER_FORMAT = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Input parameter cannot be null or empty");
        }
        String header = lines.get(0);
        if (!header.equals(HEADER_FORMAT)) {
            throw new RuntimeException("Invalid file header. "
                    + "Expected 'type,fruit,quantity' but found: " + lines.get(0));
        }

        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String currentLine = lines.get(i).trim();
            if (currentLine.isEmpty()) {
                continue;
            }
            fruitTransactions.add(parseLineToTransaction(currentLine));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLineToTransaction(String line) {

        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid line format. Expected 3 columns, found: "
                    + parts.length);
        }
        FruitTransaction.Operation operation = getOperationByCode(parts[0]);
        String fruitName = parseFruitName(parts[1]);
        int quantity = parseQuantity(parts[2]);
        return new FruitTransaction(operation, fruitName, quantity);
    }

    private FruitTransaction.Operation getOperationByCode(String operationCode) {
        String code = operationCode.trim();
        if (FruitTransaction.Operation.isCodeExists(code)) {
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
        }
        throw new RuntimeException("Input line is invalid: unknown operation code");
    }

    private String parseFruitName(String fruitName) {
        String fruit = fruitName.trim();
        if (fruit.isEmpty()) {
            throw new RuntimeException("Input line is invalid: fruit name should not be empty");
        }
        return fruit;
    }

    private int parseQuantity(String quantityString) {
        int quantity;
        try {
            quantity = Integer.parseInt(quantityString.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input line is invalid: quantity part is invalid");
        }
        if (quantity < 0) {
            throw new RuntimeException("Input line is invalid: quantity should not be negative");
        }
        return quantity;
    }
}
