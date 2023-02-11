package core.basesyntax.service.impl;

import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TRANSACTION_FORMAT_OPERATION_INDEX = 0;
    private static final int TRANSACTION_FORMAT_NAME_INDEX = 1;
    private static final int TRANSACTION_FORMAT_VALUE_INDEX = 2;
    private static final String CSV_FORMAT_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        return strings.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String transactionLine) {
        String[] split = transactionLine.split(CSV_FORMAT_SEPARATOR);

        return new FruitTransaction()
                .setOperation(Operation.getOperationByCode(
                        split[TRANSACTION_FORMAT_OPERATION_INDEX]))
                .setFruitName(split[TRANSACTION_FORMAT_NAME_INDEX])
                .setValueOfFruit(Integer.valueOf(
                        split[TRANSACTION_FORMAT_VALUE_INDEX]));
    }
}
