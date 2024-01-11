package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitsData) {
        return fruitsData
                .stream()
                .map(row -> row.split(SEPARATOR))
                .filter(data -> data[OPERATION_INDEX].trim().length() == 1)
                .map(this::createTransactionFromData)
                .collect(Collectors.toList());
    }

    public FruitTransaction createTransactionFromData(String[] data) {
        try {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperation(data[OPERATION_INDEX].trim());
            String fruit = data[FRUIT_INDEX];
            int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            return new FruitTransaction(operation, fruit, quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Fruit quantity couldn't be parsed: "
                    + data[QUANTITY_INDEX]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal data: " + Arrays.toString(data), e);
        }
    }
}
