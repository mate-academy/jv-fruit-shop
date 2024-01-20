package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class FruitTransactionImpl implements FruitTransaction {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public FruitTransactionImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void balance(String fruit, int quantity) {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.BALANCE);
        handler.getOperation(fruitDao, fruit, quantity);
    }

    @Override
    public void supply(String fruit, int quantity) {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.SUPPLY);
        handler.getOperation(fruitDao, fruit, quantity);
    }

    @Override
    public void purchase(String fruit, int quantity) {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.PURCHASE);
        handler.getOperation(fruitDao, fruit, quantity);
    }

    @Override
    public void returnFruits(String fruit, int quantity) {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.RETURN);
        handler.getOperation(fruitDao, fruit, quantity);
    }
}
