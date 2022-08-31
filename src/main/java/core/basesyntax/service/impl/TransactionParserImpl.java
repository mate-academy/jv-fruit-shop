package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataOperationHandler;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements DataOperationHandler {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> handle(List<String> operationList) {
        return operationList.stream()
                .map(operation -> operation.split(REGEX))
                .map(array -> new Transaction(Transaction.Operation.fromString(array[OPERATION]),
                        new Fruit(array[FRUIT]),
                        Integer.parseInt(array[QUANTITY])))
                .collect(Collectors.toList());
    }
}
