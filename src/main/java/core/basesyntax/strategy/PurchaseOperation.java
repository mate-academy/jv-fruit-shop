package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void executeOperation(String fruit, int quantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.subtract(fruit, quantity);
    }
}
