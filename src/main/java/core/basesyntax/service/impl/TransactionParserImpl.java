package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int HEAD_OF_INPUT = 1;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> operationList) {
        return operationList.stream()
                .skip(HEAD_OF_INPUT)
                .map(operation -> operation.split(REGEX))
                .map(array -> new Transaction(Transaction.Operation.getFromString(array[OPERATION]),
                        new Fruit(array[FRUIT]),
                        Integer.parseInt(array[QUANTITY])))
                .collect(Collectors.toList());
    }
}
