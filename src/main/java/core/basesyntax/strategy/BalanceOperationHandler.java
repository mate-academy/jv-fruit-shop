package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(Fruit fruit, FruitDao fruitDao) {
        fruitDao.add(fruit);
    }
}
