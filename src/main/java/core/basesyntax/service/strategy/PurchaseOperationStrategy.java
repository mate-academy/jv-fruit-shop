package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationStrategy implements OperationStrategy {
    private Storage storage;

    public PurchaseOperationStrategy(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        if (storage.getFruitQuantity(transaction.getFruit())
                - transaction.getQuantity() >= 0) {
            storage.updateFruitQuantity(transaction.getFruit(),
                    storage.getFruitQuantity(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new IllegalArgumentException("There are not enough fruits quantity");
        }
    }
}
