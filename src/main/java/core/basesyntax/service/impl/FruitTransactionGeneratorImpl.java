package core.basesyntax.service.impl;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionGeneratorImpl implements FruitTransactionGenerator {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> createFruitTransaction(List<String> metadata) {
        return metadata.stream()
                .map(s -> s.split(","))
                .map(t ->
                new FruitTransaction(FruitTransaction
                .Operation
                .getByCode(t[INDEX_OF_OPERATION]),
                        t[INDEX_OF_FRUIT_NAME],
                        Integer.parseInt(t[INDEX_OF_FRUIT_QUANTITY])))
                .collect(Collectors.toList());
    }
}
