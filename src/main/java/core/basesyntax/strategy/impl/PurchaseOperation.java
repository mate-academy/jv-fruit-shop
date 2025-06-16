package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityToPurchase = transaction.getQuantity();
        int currentQuantity = fruitDao.get(fruitName);

        if (currentQuantity < quantityToPurchase) {
            throw new RuntimeException("Not enough fruit in storage to perform purchase. "
                    + "Available: " + currentQuantity + ", but tried to purchase: "
                    + quantityToPurchase + " of " + fruitName);
        }

        int newQuantity = currentQuantity - quantityToPurchase;
        fruitDao.update(fruitName, newQuantity);
    }
}
