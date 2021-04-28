package core.basesyntax.store.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class ReturnHandler implements TypeHandler {
    private final FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makeOperation(String fruitName, long quantity) {
        fruitDao.update(fruitName, quantity);
    }
}
