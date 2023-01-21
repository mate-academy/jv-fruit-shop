package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, quantity);
    }
}
