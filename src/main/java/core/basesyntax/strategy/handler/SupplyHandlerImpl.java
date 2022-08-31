package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandlerImpl implements TransactionHandler {
    private final StorageDao storageDao;

    public SupplyHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeTransaction(FruitTransaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruit());
        Integer amount = storageDao.getAmount(fruit);
        storageDao.update(fruit, amount + transaction.getAmount());
    }
}
