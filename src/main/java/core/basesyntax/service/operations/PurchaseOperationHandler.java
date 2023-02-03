package core.basesyntax.service.operations;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void proceedOperation(FruitTransaction fruitTransaction) {
        Integer fruitQuantityBeforePurchase = Storage.report.get(fruitTransaction.getFruit());
        int fruitQuantityAfterPurchase = fruitQuantityBeforePurchase
                - fruitTransaction.getQuantity();
        if (fruitQuantityAfterPurchase > 0) {
            Storage.report.put(fruitTransaction.getFruit(), fruitQuantityAfterPurchase);
        }
    }
}
