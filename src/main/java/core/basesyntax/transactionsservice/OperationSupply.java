package core.basesyntax.transactionsservice;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Transaction;

public class OperationSupply implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public OperationSupply(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        fruitStorageDao.addFruitToStorage(transaction.getFruit(),
                fruitStorageDao.getFruitQuantityInStorage(transaction.getFruit())+ transaction.getAmount());
    }
}
