package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int HEADER_INDEX = 1;
    private static final int EXPECTED_LINE_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        if (report == null || report.isEmpty()) {
            throw new IllegalArgumentException("Report can't be empty");
        }
        if (report.size() < 2) {
            throw new IllegalArgumentException(
                    "Report must contain at least one data line except header");
        }

        return report.stream()
                .skip(HEADER_INDEX)
                .map(l -> {
                    String[] lines = l.split(",");
                    validateLines(lines);
                    validateFruit(lines[FRUIT_INDEX], l);
                    int quantity = validateAndParseQuantity(lines[QUANTITY_INDEX], l);
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(FruitTransaction
                            .Operation.getOperationFromCode(lines[OPERATION_INDEX]));
                    transaction.setFruit(lines[FRUIT_INDEX]);
                    transaction.setQuantity(quantity);
                    return transaction;
                })
                .toList();
    }

    private void validateLines(String[] lines) {
        if (lines.length != EXPECTED_LINE_PARTS) {
            throw new IllegalArgumentException(
                    "Incorrect file parts. Expected 3, but was: " + lines.length);
        }
    }

    private void validateFruit(String fruitName, String line) {
        if (fruitName == null || fruitName.isEmpty()) {
            throw new IllegalArgumentException("Invalid fruit name on line: " + line);
        }
    }

    private int validateAndParseQuantity(String quantityLine, String line) {
        if (quantityLine == null || quantityLine.isEmpty()) {
            throw new IllegalArgumentException("Invalid fruit quantity on line: " + line);
        }
        int quantity;
        try {
            quantity = Integer.parseInt(quantityLine);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity: " + quantityLine, e);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be not negative: " + quantity);
        }
        return quantity;
    }
}
