package core.basesyntax.optration.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.optration.OperationHandler;

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
                    "can't get operation result.Purchase quantity is " + purchaseQty + "!");
        }
    }
}
