package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationStrategy implements OperationStrategy {
    private Storage storage;

    public ReturnOperationStrategy(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(),
                storage.getFruitQuantity(transaction.getFruit()) + transaction.getQuantity());
    }
}
