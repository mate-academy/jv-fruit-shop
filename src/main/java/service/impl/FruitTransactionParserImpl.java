package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public FruitTransaction parse(String line) {
        String[] parts = line.split(SEPARATOR);
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid transaction format: " + line);
        }

        FruitTransaction.Operation operation;
        try {
            operation = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation code: "
                        + parts[OPERATION_INDEX], e);
        }

        String fruit = parts[FRUIT_INDEX];
        int quantity;
        try {
            quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity: " + parts[QUANTITY_INDEX], e);
        }

        return new FruitTransaction(operation, fruit, quantity);
    }

    @Override
    public List<FruitTransaction> parseLines(List<String> lines) {
        return lines.stream()
                .skip(1) // skip header line
                .map(this::parse)
                .toList();
    }
}
