package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void warehouse(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentBalance = storage.getFruitBalance(fruit);
        int newBalance = currentBalance - fruitTransaction.getQuantity();

        if (newBalance < 0) {
            throw new RuntimeException("Fruits balance less than "
                    + fruitTransaction.getQuantity());
        }
        storage.setFruitBalance(fruit, newBalance);
    }
}
