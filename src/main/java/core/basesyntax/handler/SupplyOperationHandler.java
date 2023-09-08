package core.basesyntax.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int amount = FruitStorage.STORAGE.getOrDefault(transaction.getFruit(), 0);
        FruitStorage.STORAGE.put(transaction.getFruit(), amount + transaction.getQuantity());
    }
}
