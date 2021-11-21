package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class RemovingOperationHandler implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public RemovingOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void getOperation(FruitTransaction fruit) {
        if (fruitTransactionDao.get(fruit.getName()).getAmount() < fruit.getAmount()) {
            throw new RuntimeException("Invalid operation, not enough fruits to buy");
        }
        fruitTransactionDao.get(fruit.getName())
                .setAmount(fruitTransactionDao.get(fruit.getName()).getAmount()
                        - fruit.getAmount());
    }
}
