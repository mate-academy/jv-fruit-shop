package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.DataParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvDataParserImpl implements DataParser {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(String data) {
        String[] lines = data.split(System.lineSeparator());
        return Arrays.stream(lines, 1, lines.length)
                .map(l -> l.split(DATA_SEPARATOR))
                .map(l -> new FruitTransaction.FruitTransactionBuilder()
                        .setOperation(FruitTransaction.operations.get(l[OPERATION_INDEX]))
                        .setFruit(l[FRUIT_NAME_INDEX])
                        .setQuantity(Integer.parseInt(l[QUANTITY_INDEX]))
                        .build())
                .collect(Collectors.toList());
    }
}
