package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public AddingOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void getOperation(FruitTransaction fruit) {
        if (fruitTransactionDao.get(fruit.getName()) == null) {
            fruitTransactionDao.add(fruit);
        } else {
            fruitTransactionDao.get(fruit.getName())
                    .setAmount(fruitTransactionDao.get(fruit.getName()).getAmount()
                            + fruit.getAmount());
        }
    }
}
