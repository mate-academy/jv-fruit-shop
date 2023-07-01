package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public void process(FruitTransaction transaction, Storage storage) {
        if (storage.getFruitQuantity(transaction.getFruit())
                - transaction.getQuantity() >= 0) {
            storage.updateFruitQuantity(transaction.getFruit(),
                    storage.getFruitQuantity(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new IllegalArgumentException("There are not enough fruits quantity");
        }
    }
}
