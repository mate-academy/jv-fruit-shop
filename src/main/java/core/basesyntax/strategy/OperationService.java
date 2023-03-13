package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public abstract class OperationService {
    protected final FruitDao fruitDao;

    public OperationService() {
        fruitDao = new FruitDaoImpl();
    }

    public abstract void executeOperation(String fruit, int amount);
}
