package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateHandler;

public class FruitBalanceStrategy implements StorageUpdateHandler {
    private final FruitDao fruitDao;

    public FruitBalanceStrategy() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void updateStorage(String fruitName, int amount) {
        fruitDao.addFirst(fruitName, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return Operation.BALANCE.getCode().equals(operationCode);
    }
}
