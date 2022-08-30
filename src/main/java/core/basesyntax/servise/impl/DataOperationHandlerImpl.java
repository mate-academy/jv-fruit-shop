package core.basesyntax.servise.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationsList;
import core.basesyntax.model.Transaction;
import core.basesyntax.servise.DataOperationHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataOperationHandlerImpl implements DataOperationHandler {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<Transaction> handle() {
        return OperationsList.list.stream()
                .map(operation -> operation.split(","))
                .map(array -> new Transaction(Transaction.Operation.valueOf(array[OPERATION]),
                        new Fruit(array[FRUIT]),
                        Integer.parseInt(array[QUANTITY])))
                .collect(Collectors.toList());
    }
}
