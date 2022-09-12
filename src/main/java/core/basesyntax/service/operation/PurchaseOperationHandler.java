package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.fruits.get(fruitTransaction.getName());
        if (currentQuantity == null) {
            throw new RuntimeException("Can't purchase! Actual quantity of "
                    + fruitTransaction.getName() + " is zero!");
        }
        if (fruitTransaction.getQuantity() > currentQuantity) {
            throw new RuntimeException("Purchase can't exceed actual quantity! Purchase quantity: "
                    + fruitTransaction.getQuantity() + " Actual quantity " + currentQuantity);
        }
        Storage.fruits.put(fruitTransaction.getName(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
