package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationService;
import java.math.BigDecimal;

public class SupplyOperationService implements OperationService {
    private FruitDao fruitDao;

    public SupplyOperationService(FruitDao fruitDao) {
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
