package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateHandler;

public class FruitSupplyHandler implements StorageUpdateHandler {
    private final FruitDao fruitDao;

    public FruitSupplyHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void updateStorage(String fruit, int amount) {
        fruitDao.add(fruit, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return Operation.SUPPLY.getCode().equals(operationCode);
    }
}
