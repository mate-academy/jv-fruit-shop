package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.FruitOperationDaoImpl;
import core.basesyntax.model.FruitOperation;

public class BalanceOperationHandler implements OperationHandler {
    private FruitOperationDao fruitOperationDao;

    public BalanceOperationHandler() {
        this.fruitOperationDao = new FruitOperationDaoImpl();
    }

    @Override
    public int getQuantityFromStore(FruitOperation fruitOperation, int value) {
        String fruitName = fruitOperation.getFruit();
        if (fruitOperationDao.get(fruitName).isPresent()) {
            throw new IllegalArgumentException("Fruit already exists in store: " + fruitName);
        }
        fruitOperationDao.add(fruitOperation);
        return value;
    }
}
