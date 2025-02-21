package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputFromCsv) {
        return inputFromCsv.stream()
                .map(this::getFromCsvRov)
                .toList();
    }

    private FruitTransaction getFromCsvRov(String line) {
        String[] fields = line.split(COMMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        String operationCode = fields[TYPE_INDEX];
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                fruitTransaction.setOperation(operation);
                break;
            }
        }
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
