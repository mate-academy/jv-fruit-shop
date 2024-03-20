package core.basesyntax.strategyimpl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void calculateValue(String fruit, int quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
            return;
        }
        Storage.fruits.put(fruit, quantity);
    }
}
