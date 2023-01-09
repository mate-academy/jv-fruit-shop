package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsServiceImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String LINE_SEPARATOR = ",";
    private static final int HEADER = 1;

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        return Arrays.stream(lines)
                .skip(HEADER)
                .map(line -> line.trim().split(LINE_SEPARATOR))
                .map(splittedLine -> new FruitTransaction.FruitTransactionBuilder()
                        .setOperation(FruitTransaction.Operation
                                .getOperationByLetter(splittedLine[OPERATION_INDEX]))
                        .setFruit(splittedLine[FRUIT_INDEX])
                        .setQuantity(Integer.parseInt(splittedLine[AMOUNT_INDEX]))
                        .build())
                .collect(Collectors.toList());
    }
}
