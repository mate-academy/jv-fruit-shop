package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;
    private FruitOperationDao fruitOperationDao;

    public FruitServiceImpl(OperationStrategy operationStrategy,
                            FruitOperationDao fruitOperationDao) {
        this.operationStrategy = operationStrategy;
        this.fruitOperationDao = fruitOperationDao;
    }

    @Override
    public void processOperations() {
        for (FruitOperation fruitOperation : fruitOperationDao.getAll()) {
            operationStrategy.get(fruitOperation.getOperation())
                    .process(fruitOperation);
        }
    }
}
