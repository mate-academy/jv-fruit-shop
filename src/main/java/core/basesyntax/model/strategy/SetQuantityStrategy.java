package core.basesyntax.model.strategy;

import core.basesyntax.dao.FruitDao;

public class SetQuantityStrategy implements OperationStrategy {
    @Override
    public void process(FruitDao fruitDao, String name, int quantity) {
        fruitDao.put(name, quantity);
    }
}
