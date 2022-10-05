package core.basesyntax.sevrice.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevrice.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate(FruitTransaction transaction) {
        OperationHandler handler = operationStrategy.get(transaction.getOperation());
        handler.handle(transaction);
    }
}
