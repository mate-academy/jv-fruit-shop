package core.basesyntax.store.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class SupplyHandler implements TypeHandler {
    FruitDao fruitDao;

    public SupplyHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void makeOperation(String fruitName, long quantity, int lineNumber) {
        fruitDao.changeBalanceForFruit(fruitName, quantity);
    }
}
