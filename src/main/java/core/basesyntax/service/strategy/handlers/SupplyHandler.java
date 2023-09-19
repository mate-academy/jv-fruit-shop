package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class SupplyHandler implements TransactionHandler {
    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        Fruit fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        return storageDao.increaseFruitsAmount(fruit, quantity);
    }
}
