package core.basesyntax.operations;

import core.basesyntax.opationstrategy.OperationHandler;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);
    }
}
