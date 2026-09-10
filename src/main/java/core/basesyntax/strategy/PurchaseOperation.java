package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (!storage.findFruit(fruit)) {
            throw new RuntimeException("Fruit " + fruit + "doesn't exists in storage");
        }
        int currentQuantity = storage.findQuantity(fruit);
        int purchaseQuantity = fruitTransaction.getQuantity();
        if (purchaseQuantity > currentQuantity) {
            throw new RuntimeException("Purchase quantity is more then available in the storage");
        }
        storage.addFruitWithQuantity(fruit, currentQuantity - purchaseQuantity);
    }
}
