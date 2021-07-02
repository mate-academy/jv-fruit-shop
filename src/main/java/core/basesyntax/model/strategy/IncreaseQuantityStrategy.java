package core.basesyntax.model.strategy;

import core.basesyntax.dao.FruitDao;

public class IncreaseQuantityStrategy implements OperationStrategy {
    @Override
    public void process(FruitDao fruitDao, String name, int quantity) {
        fruitDao.put(name, fruitDao.getQuantity(name) + quantity);
    }
}
