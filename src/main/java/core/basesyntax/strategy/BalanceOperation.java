package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;

public class BalanceOperation implements OperationHandler {
    @Override
    public void getOperation(String fruit, int quantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.add(fruit, quantity);
    }
}
