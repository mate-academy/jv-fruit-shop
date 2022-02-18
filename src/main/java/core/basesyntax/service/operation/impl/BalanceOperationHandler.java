package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    public static final int INVALID_QUANTITY_MARKER = 0;
    private final FruitDao fruitStorageDao;

    public BalanceOperationHandler() {
        this.fruitStorageDao = new FruitDaoImpl();
    }

    @Override
    public void updateBalance(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY_MARKER) {
            throw new RuntimeException("Balance cann`t be negative");
        }
        Fruit fruit = fruitStorageDao.get(fruitTransaction.getFruit());
        fruit.setQuantity(fruitTransaction.getQuantity());
    }
}
