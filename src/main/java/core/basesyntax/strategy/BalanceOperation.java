package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationStrategy {

    @Override
    public void processTransaction(FruitTransaction transaction, Storage storage) {
        storage.setFruits(transaction.getFruit(), transaction.getQuantity());
    }
}
