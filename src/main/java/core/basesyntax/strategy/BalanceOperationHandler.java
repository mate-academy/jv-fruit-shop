package core.basesyntax.strategy;

import core.basesyntax.Storage;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        Storage.inventory.put(fruit, quantity);
    }
}
