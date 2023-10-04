package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertService;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertServiceImpl implements ConvertService {
    private static final String COMMA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int NORMAL_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertData(List<String> lines) {
        return lines.stream()
                .map(line -> line.split(COMMA_SEPARATOR))
                .filter(values -> values.length >= NORMAL_LENGTH)
                .map(value -> {
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.getOperationByCode(value[OPERATION_INDEX]);
                    String fruit = value[FRUIT_INDEX];
                    int quantity = Integer.parseInt(value[QUANTITY_INDEX]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
