package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.getStorage().getOrDefault(
                transaction.getFruit(), 0);
        Storage.getStorage().put(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
