package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataStorage;
import java.util.List;

public class DataStorageImpl implements DataStorage {
    private static final String SEPARATOR = ",";
    private static final int INDEX_BY_TRANSACTION = 0;
    private static final int INDEX_BY_FRUIT = 1;
    private static final int INDEX_BY_AMOUNT = 2;

    @Override
    public List<FruitTransaction> convertText(List<String> strings) {
        return strings.stream()
                .map(line -> line.split(SEPARATOR))
                .map(data -> new FruitTransaction(
                        Operation.getTransactionByCode(data[INDEX_BY_TRANSACTION]),
                        data[INDEX_BY_FRUIT],
                        Integer.parseInt(data[INDEX_BY_AMOUNT])
                ))
                .toList();
    }
}
