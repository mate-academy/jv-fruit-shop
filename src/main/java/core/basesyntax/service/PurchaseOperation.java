package core.basesyntax.service;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);
    }
}

