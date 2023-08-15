package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.MyOwnException;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        Fruit fruitFromDb = fruitDao.get(fruitName);
        if (fruitFromDb == null) {
            throw new MyOwnException("There isn't such fruit in the storage:" + fruitName);
        }
        BigDecimal oldQuantity = fruitFromDb.getQuantity();
        if (oldQuantity.compareTo(quantity) >= 0) {
            BigDecimal newQuantity = oldQuantity.subtract(quantity);
            fruitFromDb.setQuantity(newQuantity);
            fruitDao.update(fruitFromDb);
        } else {
            throw new MyOwnException("The quantity in storage is less than the quantity for sale: "
                    + oldQuantity + " < " + quantity);
        }
    }
}
