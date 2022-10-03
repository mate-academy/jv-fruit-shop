package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.ParseFruits;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFruitsImpl implements ParseFruits {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int SKIP_NAMES_LINE = 1;
    private static final String CSV_LINE_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> transactions(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(SKIP_NAMES_LINE)
                .map(line -> line.split(CSV_LINE_SEPARATOR))
                .map(fields -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    Operation operation = Operation.getOperation(fields[OPERATION_INDEX]);
                    fruitTransaction.setOperation(operation);
                    fruitTransaction.setFruit((String.valueOf(fields[FRUIT_INDEX])));
                    fruitTransaction.setQuantity(Integer.parseInt(fields[FRUIT_QUANTITY_INDEX]));
                    return fruitTransaction;
                }).collect(Collectors.toList());
    }
}
