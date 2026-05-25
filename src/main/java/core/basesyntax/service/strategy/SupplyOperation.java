package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int old = Storage.getStorage().getOrDefault(transaction.getFruit(), 0);
        Storage.getStorage().put(transaction.getFruit(), old + transaction.getQuantity());
    }
}
