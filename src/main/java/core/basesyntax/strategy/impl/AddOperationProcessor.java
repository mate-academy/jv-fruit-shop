package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationProcessor;

public class AddOperationProcessor implements OperationProcessor {
    private final FruitDao fruitDao;

    public AddOperationProcessor(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(Transaction fruitTransaction) {
        if (fruitDao.get(fruitTransaction.getProductName()) != null) {
            int value = fruitDao.get(fruitTransaction.getProductName())
                    + fruitTransaction.getQuantity();
            fruitDao.add(fruitTransaction.getProductName(), value);
        } else {
            fruitDao.add(fruitTransaction.getProductName(), fruitTransaction.getQuantity());
        }
    }
}
