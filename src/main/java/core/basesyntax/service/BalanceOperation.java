package core.basesyntax.service;

import java.util.Map;

public class BalanceOperation implements OperationHandler {
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, quantity);
    }
}

