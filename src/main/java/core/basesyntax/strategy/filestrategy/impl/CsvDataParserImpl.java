package core.basesyntax.strategy.filestrategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.filestrategy.DataParser;
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
        return Arrays.stream(lines)
                .skip(1)
                .map(line -> line.split(DATA_SEPARATOR))
                .map(splittedLine -> new FruitTransaction.FruitTransactionBuilder()
                        .setOperation(Operation.getOperationByLetter(splittedLine[OPERATION_INDEX]))
                        .setFruit(splittedLine[FRUIT_NAME_INDEX])
                        .setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]))
                        .build())
                .collect(Collectors.toList());
    }
}
