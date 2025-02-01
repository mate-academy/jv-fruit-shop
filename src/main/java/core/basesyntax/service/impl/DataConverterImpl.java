package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMA = ",";
    private static final int TITLE_POSITION = 1;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(TITLE_POSITION)
                .map(d -> {
                    String[] fields = d.split(COMA);
                    Operation operation = Operation.fromCode(fields[OPERATION_POSITION]);
                    String fruit = fields[FRUIT_POSITION];

                    if (!fields[QUANTITY_POSITION].matches("\\d+")) {
                        throw new IllegalArgumentException("Invalid quantity: "
                                + fields[QUANTITY_POSITION]);
                    }
                    int quantity = Integer.parseInt(fields[QUANTITY_POSITION]);

                    return new FruitTransaction(operation, fruit, quantity);
                })
                .toList();
    }
}
