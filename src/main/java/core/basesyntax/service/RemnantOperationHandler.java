package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class RemnantOperationHandler implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void handle(String name, int amount) {
        fruitDao.set(name, amount);
    }
}
