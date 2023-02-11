package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.storageFruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
