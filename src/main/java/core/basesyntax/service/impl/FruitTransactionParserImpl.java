package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_COUNT = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .skip(1)
                .map(str -> str.split(SPLITTER))
                .map(this::creareFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction creareFruitTransaction(String[] fields) {
        return new FruitTransaction(fields[INDEX_OF_OPERATION_TYPE],
                new Fruit(fields[INDEX_OF_FRUIT_TYPE]),
                Integer.parseInt(fields[INDEX_OF_COUNT]));
    }
}
