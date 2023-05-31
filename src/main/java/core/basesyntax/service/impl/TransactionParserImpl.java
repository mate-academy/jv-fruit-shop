package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int FIRST_LINE_SKIP_COUNT = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> getTransactions(List<String> linesFromFile) {
        return linesFromFile.stream()
                .skip(FIRST_LINE_SKIP_COUNT)
                .map(line -> line.split(COMMA_SEPARATOR))
                .map(splittedLine -> new FruitTransaction(
                        FruitTransaction.Operation.getOperation(splittedLine[OPERATION_INDEX]),
                        splittedLine[FRUIT_NAME_INDEX],
                        Integer.parseInt(splittedLine[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
