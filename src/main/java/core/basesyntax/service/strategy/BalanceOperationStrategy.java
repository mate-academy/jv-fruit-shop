package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationStrategy {
    private Storage storage;

    public BalanceOperationStrategy(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
