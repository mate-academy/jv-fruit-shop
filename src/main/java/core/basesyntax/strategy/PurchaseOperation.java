package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationStrategy {

    @Override
    public void processTransaction(FruitTransaction transaction, Storage storage) {
        int currentQuantity = storage.getFruitCount(transaction.getFruit());
        int resultQuantity = currentQuantity - transaction.getQuantity();
        if (resultQuantity < 0) {
            throw new RuntimeException("Insufficient quantity of "
                    + transaction.getFruit() + "s in storage. "
                    + "Unable to process transaction." + System.lineSeparator()
                    + "Current quantity in storage: " + currentQuantity + System.lineSeparator()
                    + "Transaction quantity: " + transaction.getQuantity());
        }
        storage.setFruits(transaction.getFruit(), resultQuantity);
    }
}
