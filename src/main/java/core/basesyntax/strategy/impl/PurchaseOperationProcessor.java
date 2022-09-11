package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationProcessor;

public class PurchaseOperationProcessor implements OperationProcessor {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void processOperation(Transaction fruitTransaction) {
        int amountOfFruit = fruitDao.get(fruitTransaction.getProductName())
                - fruitTransaction.getQuantity();
        if (amountOfFruit < 0) {
            throw new RuntimeException("You don't have enough "
                    + fruitTransaction.getProductName());
        }
        fruitDao.add(fruitTransaction.getProductName(), amountOfFruit);
    }
}
