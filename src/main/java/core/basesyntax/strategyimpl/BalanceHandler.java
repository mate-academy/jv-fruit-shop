package core.basesyntax.strategyimpl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public Map<String, Integer> handle(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
        return Storage.fruits;
    }
}
