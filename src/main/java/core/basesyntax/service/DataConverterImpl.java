package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    public static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> records) {
        return records.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(SEPARATOR);
                    FruitTransaction.Operation operation = FruitTransaction
                            .Operation
                            .fromCode(parts[OPERATION_INDEX]);
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(operation);
                    fruitTransaction.setFruit(parts[FRUIT_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(parts[QUANTITY_INDEX]));
                    return fruitTransaction;
                }).collect(Collectors.toList());
    }
}
