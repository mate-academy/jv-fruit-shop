package core.basesyntax.transactionsService;

import core.basesyntax.DAO.FruitStorageDao;
import core.basesyntax.model.Transaction;

public class OperationPurchase implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public OperationPurchase(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        if (fruitStorageDao.getFruitQuantityInStorage(transaction.getFruit()) < transaction.getAmount()) {
            throw new RuntimeException("Not enough " + transaction.getFruit().getFruitName()
                    + " in storage to purchase " + transaction.getAmount());
        } else {
            fruitStorageDao.addFruitToStorage(transaction.getFruit(),
                    fruitStorageDao.getFruitQuantityInStorage(transaction.getFruit()) - transaction.getAmount());
        }
    }

}
