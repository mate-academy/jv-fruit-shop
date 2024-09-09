package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        storage.merge(fruit, quantity, Integer::sum);
    }
}
