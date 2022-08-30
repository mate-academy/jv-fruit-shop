package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandlerImpl implements TransactionHandler<FruitTransaction> {
    private final StorageDao storageDao;

    public PurchaseHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }
    @Override
    public void makeTransaction(FruitTransaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruit());
        Integer amount = storageDao.getAmount(fruit);
        if (storageDao.getAmount(fruit) > transaction.getAmount()) {
            storageDao.update(fruit,amount - transaction.getAmount());
        }
    }
}
