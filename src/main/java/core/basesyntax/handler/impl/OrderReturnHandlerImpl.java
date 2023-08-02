package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.OrderReturnHandler;

public class OrderReturnHandlerImpl implements OrderReturnHandler {
    @Override
    public boolean returnOrder(String fruitName, int quantityToReturn) {
        boolean isReturned = false;
        int druitQuantity = FruitsStorage.fruitsStorage.get(fruitName);
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            druitQuantity = druitQuantity + quantityToReturn;
        }
        FruitsStorage.fruitsStorage.put(fruitName, druitQuantity);
        isReturned = true;
        return isReturned;
    }
}
