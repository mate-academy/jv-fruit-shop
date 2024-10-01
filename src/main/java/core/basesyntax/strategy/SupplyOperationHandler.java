package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void updateFruitStorage(FruitTransaction fruitTransaction,
                                   FruitStorageDao fruitStorageDao) {
        fruitStorageDao.increaseQuantity(fruitTransaction);
    }
}
