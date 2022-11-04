package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserData;
import java.util.List;
import java.util.stream.Collectors;

public class ParserDataImpl implements ParserData {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        return dataFromFile.stream()
                .map(s -> s.split(SEPARATOR))
                .map(t -> getFruitTransaction(t))
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String[] transaction) {
        return new FruitTransaction(transaction[INDEX_OF_OPERATION],
                transaction[INDEX_OF_FRUIT_NAME], Integer.parseInt(transaction[INDEX_OF_QUANTITY]));
    }
}
