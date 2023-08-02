package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.PurchaseHandler;

public class PurchaseHandlerImpl implements PurchaseHandler {
    @Override
    public boolean purchase(String fruitName, int quantityToSubtract) {
        boolean isSubstracted = false;
        int fruitQuantity = FruitsStorage.fruitsStorage.get(fruitName);
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            fruitQuantity = fruitQuantity - quantityToSubtract;
        }
        FruitsStorage.fruitsStorage.put(fruitName, fruitQuantity);
        isSubstracted = true;
        return isSubstracted;
    }
}
