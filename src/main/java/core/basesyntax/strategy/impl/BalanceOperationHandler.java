package core.basesyntax.strategy.impl;

import core.basesyntax.database.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private static final int ZERO = 0;
    private StorageDaoImpl storageDao;

    public BalanceOperationHandler() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void updateQuantity(FruitTransaction transaction) {
        if (transaction.getQuantity() < ZERO) {
            throw new RuntimeException("Quantity of transaction can't be less than zero");
        }
        if (!storageDao.fruitIsInStorage(transaction.getFruit())) {
            storageDao.add(new Fruit(transaction.getFruit()));
        }
        Fruit fruit = storageDao.get(transaction.getFruit());
        fruit.setQuantity(transaction.getQuantity());
    }
}
