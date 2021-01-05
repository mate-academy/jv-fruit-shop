package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Storage storage, Fruit fruit, int amount) {
        storage.getStorage().put(fruit, amount);
    }
}
