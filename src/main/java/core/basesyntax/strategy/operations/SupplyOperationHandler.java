package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorageDao storageDao = new FruitStorageDao();

    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.fruitName(), fruitTransaction.quantity());
    }
}
