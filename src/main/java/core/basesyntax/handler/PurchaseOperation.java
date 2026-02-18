package core.basesyntax.handler;

import core.basesyntax.*;

import java.util.*;

public class PurchaseOperation implements OperationHandler{

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(),
                storage.get(transaction.getFruit())
        - transaction.getQuantity());
    }
}
