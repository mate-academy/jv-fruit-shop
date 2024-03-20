package core.basesyntax.strategyimpl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public Map<String, Integer> calculateValue(String fruit, int quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) - quantity);
            return Storage.fruits;
        }
        return Storage.fruits;
    }
}
