package core.basesyntax.transactionsService;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Transaction;

public class OperationBalance extends Transaction implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public OperationBalance(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        fruitStorageDao.addFruitToStorage(transaction.getFruit(), transaction.getAmount());
    }
}
