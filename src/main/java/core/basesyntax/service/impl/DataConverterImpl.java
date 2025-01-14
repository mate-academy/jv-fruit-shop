package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    public static final int TITLE_POSITION = 1;
    public static final int OPERATION_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(TITLE_POSITION)
                .map(d -> {
                    String[] fields = d.split(",");
                    Operation operation = Operation.fromCode(fields[OPERATION_POSITION].trim());
                    String fruit = fields[FRUIT_POSITION];
                    int quantity = Integer.parseInt(fields[QUANTITY_POSITION]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
