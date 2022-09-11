package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationProcessor;

public class SubstractOperationProcessor implements OperationProcessor {
    private final FruitDao fruitDao;

    public SubstractOperationProcessor(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(Transaction fruitTransaction) {
        int amountOfFruit = fruitDao.get(fruitTransaction.getProductName())
                - fruitTransaction.getQuantity();
        if (amountOfFruit < 0) {
            throw new RuntimeException("You don't have enough "
                    + fruitTransaction.getProductName());
        }
        fruitDao.add(fruitTransaction.getProductName(), amountOfFruit);
    }
}
