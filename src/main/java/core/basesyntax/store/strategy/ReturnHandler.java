package core.basesyntax.store.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class ReturnHandler implements TypeHandler {
    private final FruitDao fruitDao;

    public ReturnHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void makeOperation(String fruitName, long quantity, int lineNumber) {
        fruitDao.update(fruitName, quantity);
    }
}
