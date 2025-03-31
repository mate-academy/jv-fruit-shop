package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.inventory.put(fruit, quantity);
    }
}
