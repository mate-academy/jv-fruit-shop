package core.basesyntax.stratagy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(final FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int fruitQuantity = transaction.getQuantity();
        int currentQuantity = Storage.getQuantity(fruit);
        int newQuantity = currentQuantity - fruitQuantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruit in storage");
        }
        Storage.setQuantity(fruit, newQuantity);
    }
}
