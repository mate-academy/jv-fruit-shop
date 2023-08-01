package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.OrderReturnHandler;
import java.math.BigDecimal;

public class OrderReturnHandlerImpl implements OrderReturnHandler {
    private final FruitsStorage storage;

    public OrderReturnHandlerImpl(FruitsStorage storage) {
        this.storage = storage;
    }

    @Override
    public boolean returnOrder(String fruitName, BigDecimal priceToReturn) {
        boolean isReturned = false;
        BigDecimal fruitPrice = storage.getFruitsStorage().get(fruitName);
        if (storage.getFruitsStorage().containsKey(fruitName)) {
            fruitPrice = fruitPrice.add(priceToReturn);
            isReturned = true;
        }
        storage.getFruitsStorage().put(fruitName, fruitPrice);
        return isReturned;
    }
}
