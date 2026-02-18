package core.basesyntax.handler;

import core.basesyntax.*;

import java.util.*;

public class ReturnOperation implements OperationHandler{
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}
