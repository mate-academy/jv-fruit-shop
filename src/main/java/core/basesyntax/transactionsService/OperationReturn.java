package core.basesyntax.transactionsService;

import core.basesyntax.DAO.FruitStorageDao;
import core.basesyntax.model.Transaction;

public class OperationReturn implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public OperationReturn(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        fruitStorageDao.addFruitToStorage(transaction.getFruit(),
                transaction.getAmount() + fruitStorageDao.getFruitQuantityInStorage(transaction.getFruit()));
    }
}
