package mate.academy.operation.impl;

import mate.academy.dao.FruitDao;
import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionInDB = fruitDao.get(fruitTransaction.getFruit());
        if (fruitTransactionInDB == null) {
            throw new RuntimeException(fruitTransaction.getFruit() + " is not available");
        }
        int diff = fruitTransactionInDB.getQuantity() - fruitTransaction.getQuantity();
        if (diff < 0) {
            throw new RuntimeException(fruitTransaction.getFruit() + " in shop is not enough");
        }
        fruitTransactionInDB.setQuantity(diff);
        fruitDao.add(fruitTransactionInDB);
    }
}
