package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.SupplierHandler;
import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class SupplierHandlerImpl implements SupplierHandler {
    private final FruitsStorage storage;

    public SupplierHandlerImpl(FruitsStorage fruitsStorage) {
        this.storage = fruitsStorage;
    }

    @Override
    public boolean add(FruitTransaction fruitTransaction) {
        boolean isAdded = false;
        String fruitName = fruitTransaction.getFruitName();
        BigDecimal fruitPrice = fruitTransaction.getFruitPrice();
        if (storage.getFruitsStorage().containsKey(fruitName)) {
            BigDecimal existingFruitPrice = storage.getFruitsStorage().get(fruitName);
            fruitPrice = fruitPrice.add(existingFruitPrice);
            isAdded = true;
        }
        storage.getFruitsStorage().put(fruitName, fruitPrice);
        return isAdded;
    }
}
