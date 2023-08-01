package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.PurchaseHandler;
import java.math.BigDecimal;

public class PurchaseHandlerImpl implements PurchaseHandler {
    private final FruitsStorage storage;

    public PurchaseHandlerImpl(FruitsStorage fruitsStorage) {
        this.storage = fruitsStorage;
    }

    @Override
    public boolean purchase(String fruitName, BigDecimal priceToSubtract) {
        boolean isSubstracted = false;
        BigDecimal fruitPrice = storage.getFruitsStorage().get(fruitName);
        if (storage.getFruitsStorage().containsKey(fruitName)) {
            fruitPrice = fruitPrice.subtract(priceToSubtract);
            isSubstracted = true;
        }
        storage.getFruitsStorage().put(fruitName, fruitPrice);
        return isSubstracted;
    }
}
