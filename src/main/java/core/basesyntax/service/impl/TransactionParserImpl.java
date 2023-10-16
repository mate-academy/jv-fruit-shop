package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int INDEX_CODE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        try {
            return data.stream()
                    .map(this::parseLine)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid value for fruit quantity");
        }
    }

    private FruitTransaction parseLine(String line) {
        String[] elements = line.split(SEPARATOR);
        String code = elements[INDEX_CODE_OPERATION];
        String name = elements[INDEX_FRUIT_NAME];
        int quantity = Integer.parseInt(elements[INDEX_FRUIT_QUANTITY]);
        if (quantity < 0) {
            throw new RuntimeException("Quantity must be greater or equal to 0!");
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation.getOperationByCode(code);
        return new FruitTransaction(operation, name, quantity);
    }
}
