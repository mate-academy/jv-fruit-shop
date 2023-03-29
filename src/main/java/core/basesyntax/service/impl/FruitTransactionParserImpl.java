package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        return Arrays.stream(lines)
                .skip(1)
                .map(line -> line.split(DATA_SEPARATOR))
                .map(split -> new FruitTransaction.FruitTransactionBuilder()
                        .setOperation(FruitTransaction.Operation.getOperationByLetter(
                                split[OPERATION_INDEX]))
                        .setFruit(split[FRUIT_INDEX])
                        .setQuantity(Integer.parseInt(split[QUANTITY_INDEX]))
                        .build())
                .collect(Collectors.toList());
    }
}
