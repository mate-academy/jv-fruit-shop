package core.basesyntax.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.operation.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void getOperationResult(FruitsTranslation fruitTransaction) {
        String resultFruits = fruitTransaction.getFruit();
        int currentQtyInStorage = Storage.fruitsMap.get(resultFruits);
        int purchaseQty = fruitTransaction.getQuantity();

        if (currentQtyInStorage >= purchaseQty) {
            Storage.fruitsMap.put(resultFruits, (currentQtyInStorage - purchaseQty));
        } else {
            throw new RuntimeException(
                    "Can't get operation result. Purchase quantity: "
                            + purchaseQty + ", while currently in storage: "
                    + currentQtyInStorage);
        }
    }
}
