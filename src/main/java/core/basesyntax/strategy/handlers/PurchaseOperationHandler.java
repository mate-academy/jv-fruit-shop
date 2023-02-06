package core.basesyntax.strategy.handlers;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer fruitQuantityBeforePurchase = Storage.fruitsQuantity.get(fruitTransaction.getFruit());
        int fruitQuantityAfterPurchase = fruitQuantityBeforePurchase
                - fruitTransaction.getQuantity();
        if (fruitQuantityAfterPurchase < 0) {
            throw new RuntimeException("There's not enough of "
                    + fruitTransaction.getFruit()
                    + " to conduct such operation");
        } else {
            Storage.fruitsQuantity.put(fruitTransaction.getFruit(), fruitQuantityAfterPurchase);
        }
    }
}
