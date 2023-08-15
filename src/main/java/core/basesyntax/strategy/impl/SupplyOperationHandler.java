package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) {
        Fruit fruitFromDb = fruitDao.get(fruitName);
        if (fruitFromDb == null) {
            fruitDao.add(new Fruit(fruitName, quantity));
        } else {
            BigDecimal newQuantity = fruitFromDb.getQuantity().add(quantity);
            fruitFromDb.setQuantity(newQuantity);
            fruitDao.update(fruitFromDb);
        }
    }
}
