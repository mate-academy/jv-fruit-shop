package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnOperation implements OperationStrategy {
    private final FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        var fruit = fruitTransaction.getFruit();
        var quantity = fruitTransaction.getQuantity();
        fruitDao.returnFruit(fruit, quantity);
    }
}
