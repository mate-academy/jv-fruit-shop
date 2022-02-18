package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;
    private OperationHandler operationHandler;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void setDataToStorage(List<FruitTransaction> fruitsTransactionList) {
        for (FruitTransaction transaction : fruitsTransactionList) {
            operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.changeData(transaction);
        }
    }
}
