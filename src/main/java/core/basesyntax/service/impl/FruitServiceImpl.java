package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private StorageDao storageDao;
    private OperationStrategy operationStrategy;
    private OperationHandler operationHandler;

    public FruitServiceImpl(StorageDao storageDao, OperationStrategy operationStrategy) {
        this.storageDao = storageDao;
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
