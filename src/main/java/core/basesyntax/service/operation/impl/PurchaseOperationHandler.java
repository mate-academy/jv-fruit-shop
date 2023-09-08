package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    public static final int INVALID_QUANTITY_MARKER = 0;
    private final FruitDao fruitStorageDao;

    public PurchaseOperationHandler() {
        this.fruitStorageDao = new FruitDaoImpl();
    }

    @Override
    public void updateBalance(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY_MARKER) {
            throw new RuntimeException("Purchase cann`t be negative");
        }
        Fruit fruit = fruitStorageDao.get(fruitTransaction.getFruit());
        int fruitBalance = fruit.getQuantity();
        if (fruitTransaction.getQuantity() > fruitBalance) {
            throw new RuntimeException("Purchase cann`t be more than previous balance");
        }
        fruit.setQuantity(fruitBalance - fruitTransaction.getQuantity());
    }
}
