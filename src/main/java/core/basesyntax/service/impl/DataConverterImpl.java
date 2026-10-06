package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        return list.stream()
                .skip(1)
                .map(l -> {
                    String[] fruitData = l.split(",");
                    FruitTransaction.Operation operation = FruitTransaction
                            .Operation.fromCode(fruitData[INDEX_OPERATION]);
                    int quantity = Integer.parseInt(fruitData[INDEX_FRUIT_QUANTITY]);
                    if (quantity < 0) {
                        throw new RuntimeException("Quantity should be greater than or equal to 0");
                    }

                    return new FruitTransaction(operation, fruitData[INDEX_FRUIT_NAME], quantity);
                })
                .toList();
    }
}
