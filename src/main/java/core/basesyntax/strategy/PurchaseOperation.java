package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationStrategy {

    @Override
    public void processTransaction(FruitTransaction transaction, Storage storage) {
        int currentQuantity = storage.getFruitCount(transaction.getFruit());
        int resultQuantity = currentQuantity - transaction.getQuantity();
        storage.setFruits(transaction.getFruit(), resultQuantity);
    }
}
