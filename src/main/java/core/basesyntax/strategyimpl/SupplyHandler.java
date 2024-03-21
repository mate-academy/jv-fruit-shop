package core.basesyntax.strategyimpl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class SupplyHandler implements OperationHandler {

    @Override
    public Map<String, Integer> handle(String fruit, int quantity) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
        return Storage.fruits;
    }
}
