package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.StorageException;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        Map.Entry<String, BigDecimal> fruitFromDb = fruitDao.get(fruitName);
        if (fruitFromDb != null) {
            BigDecimal newQuantity = fruitFromDb.getValue().add(quantity);
            fruitDao.update(fruitName, newQuantity);
        } else {
            throw new StorageException("There isn't such fruit in the storage: "
                    + fruitName);
        }
    }
}
