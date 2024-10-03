package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void updateFruitStorage(FruitTransaction fruitTransaction,
                                   FruitStorageDao fruitStorageDao) {
        fruitStorageDao.addFruit(fruitTransaction);
    }
}
