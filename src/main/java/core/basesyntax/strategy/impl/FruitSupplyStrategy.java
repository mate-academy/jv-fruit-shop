package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateStrategy;

public class FruitSupplyStrategy implements StorageUpdateStrategy {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void updateStorage(String fruit, int amount) {
        fruitDao.add(fruit, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return operationCode.equals(Operation.SUPPLY.getCode());
    }
}
