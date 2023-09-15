package core.basesyntax.model.handler.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.exception.InvalidDataException;
import core.basesyntax.model.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(fruit);
        int amount = transaction.getAmount();
        if (quantity == 0) {
            throw new InvalidDataException(String.format(
                    "There are no %ss in storage.",
                    fruit));
        }
        if (quantity < amount) {
            throw new InvalidDataException(String.format(
                    "Not enough %ss in storage: %d. You want to purchase: %d.",
                    fruit, quantity, amount));
        }
        fruitStorageDao.updateFruitQuantity(fruit, quantity - amount);
    }
}
