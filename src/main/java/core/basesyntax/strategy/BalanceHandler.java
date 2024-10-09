package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceHandler implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> inventory) {
        inventory.put(transaction.getFruit(),
                Math.max(transaction.getQuantity(), 0));
    }
}
