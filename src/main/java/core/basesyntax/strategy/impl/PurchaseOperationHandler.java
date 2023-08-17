package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.StorageException;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        Map.Entry<String, BigDecimal> fruitFromDb = fruitDao.get(fruitName);
        if (fruitFromDb == null) {
            throw new StorageException("There isn't such fruit in the storage: " + fruitName);
        }
        BigDecimal oldQuantity = fruitFromDb.getValue();
        if (oldQuantity.compareTo(quantity) >= 0) {
            BigDecimal newQuantity = oldQuantity.subtract(quantity);
            fruitDao.update(fruitName, newQuantity);
        } else {
            throw new StorageException("The quantity of " + fruitName
                    + " in storage is less than the quantity for sale: "
                    + oldQuantity + " < " + quantity);
        }
    }
}
