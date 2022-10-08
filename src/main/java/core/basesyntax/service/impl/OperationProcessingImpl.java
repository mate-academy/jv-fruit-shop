package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessing;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class OperationProcessingImpl implements OperationProcessing {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public OperationProcessingImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
        handler.handle(fruitTransaction);
    }
}
