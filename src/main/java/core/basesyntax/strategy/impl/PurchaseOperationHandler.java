package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.NoSuchElementException;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        fruitStorageDao.remove(fruit, fruitTransaction.getQuantity());
    }
}
