package core.basesyntax.data.strategy;

import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }
}
