package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int INFO_LINE_INDEX = 1;
    private static final int EXPECTED_PARTS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        if (report == null || report.isEmpty()) {
            throw new IllegalArgumentException(
                    "Report list cannot be null or empty");
        }
        if (report.size() < 2) {
            throw new IllegalArgumentException(
                    "Report must contain header and at least one data line");
        }
        return report.stream()
                .skip(INFO_LINE_INDEX)
                .map(line -> {
                    String[] parts = line.split(",");
                    if (parts.length != EXPECTED_PARTS_COUNT) {
                        throw new IllegalArgumentException(
                                "Invalid CSV format. Expected 3 parts, but got: "
                                        + parts.length
                        );
                    }
                    validateFruitName(parts[FRUIT_INDEX], line);
                    int quantity = parseAndValidateQuantity(parts[QUANTITY_INDEX], line);
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(FruitTransaction.Operation
                            .fromCode(parts[OPERATION_INDEX]));
                    transaction.setFruit(parts[FRUIT_INDEX]);
                    transaction.setQuantity(quantity);
                    return transaction;
                })
                .collect(Collectors.toList());
    }

    private void validateFruitName(String value, String line) {
        if (value == null) {
            throw new RuntimeException(
                    "Fruit name is null: " + line);
        }
        if (value.isEmpty()) {
            throw new RuntimeException(
                    "Fruit name is empty: " + line);
        }
    }

    private int parseAndValidateQuantity(String value, String line) {
        if (value == null) {
            throw new RuntimeException(
                    "Fruit quantity is null: " + line);
        }
        if (value.isEmpty()) {
            throw new RuntimeException(
                    "Fruit quantity is empty: " + line);
        }
        int quantity;
        try {
            quantity = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Fruit quantity is invalid: " + value, e);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Fruit quantity is negative: " + line);
        }
        return quantity;
    }
}
