package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitsData) {
        return fruitsData.stream()
                .map(row -> row.split(","))
                .filter(data -> data[OPERATION_INDEX].trim().length() == 1)
                .map(this::createTransactionFromData)
                .collect(Collectors.toList());
    }

    public FruitTransaction createTransactionFromData(String[] data) {
        try {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperation(data[OPERATION_INDEX].trim());
            String fruit = data[FRUIT_INDEX];
            int quantity = Integer.parseInt(data[AMOUNT_INDEX]);
            return new FruitTransaction(fruit, operation, quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Amount of fruits could not be parsed : "
                + data[AMOUNT_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Data is not according to requirements : "
                    + Arrays.toString(data), e);
        }
    }
}
