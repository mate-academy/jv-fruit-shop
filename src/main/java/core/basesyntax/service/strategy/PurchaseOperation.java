package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.exception.NotEnoughProductsException;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private FruitStorageDao storageDao;

    public PurchaseOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentFruitQuantity = storageDao.getFruitQuantity(transaction.getFruit());
        int purchaseResult = currentFruitQuantity - transaction.getQuantity();
        if (purchaseResult < 0) {
            throw new NotEnoughProductsException("Not enough fruits: "
                        + transaction.getFruit()
                        + ": "
                        + transaction.getQuantity()
                        + " available: "
                        + currentFruitQuantity);
        }
        storageDao.getAllFruits().put(transaction.getFruit(), purchaseResult);
    }
}
