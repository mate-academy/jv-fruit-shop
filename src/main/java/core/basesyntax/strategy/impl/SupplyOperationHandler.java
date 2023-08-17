package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        Map.Entry<String, BigDecimal> fruitFromDb = fruitDao.get(fruitName);
        if (fruitFromDb == null) {
            fruitDao.add(fruitName, quantity);
        } else {
            BigDecimal newQuantity = fruitFromDb.getValue().add(quantity);
            fruitDao.update(fruitName, newQuantity);
        }
    }
}
