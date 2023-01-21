package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void process(String fruit, int quantity, Map<String, Integer> storage) {
        storage.replace(fruit, storage.get(fruit),
                storage.get(fruit) - quantity);
    }
}
