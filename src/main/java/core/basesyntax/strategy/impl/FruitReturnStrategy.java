package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateHandler;

public class FruitReturnStrategy implements StorageUpdateHandler {
    private final FruitDao fruitDao;

    public FruitReturnStrategy() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void updateStorage(String fruitName, int amount) {
        fruitDao.add(fruitName, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return Operation.RETURN.getCode().equals(operationCode);
    }
}
