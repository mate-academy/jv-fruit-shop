package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseData;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataImpl implements ParseData {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parser(List<String> fruitsData) {
        return fruitsData
                .stream()
                .map(row -> row.split(SEPARATOR))
                .filter(data -> data[OPERATION_INDEX].trim().length() == 1)
                .map(data -> {
                    try {
                        FruitTransaction.Operation operation = FruitTransaction.Operation
                                    .getOperation(data[OPERATION_INDEX].trim());
                        String fruit = data[FRUIT_INDEX];
                        int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
                        return new FruitTransaction(operation, fruit, quantity);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("Illegal data");
                    }
                })
                .collect(Collectors.toList());
    }
}
