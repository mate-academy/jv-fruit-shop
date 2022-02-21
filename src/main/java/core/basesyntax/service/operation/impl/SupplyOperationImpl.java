package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.operation.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private final FruitDao<String, Integer> fruitDao;

    public SupplyOperationImpl(FruitDao<String, Integer> fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean operation(String fruitName, int quantity) {
        fruitDao.addStorage(fruitName, quantity);
        return true;
    }
}
