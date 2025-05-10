package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
