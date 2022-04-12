package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationStrategy operationStrategy;
    private final StorageDao storageDao;

    public OperationServiceImpl(OperationStrategy operationStrategy, StorageDao storageDao) {
        this.operationStrategy = operationStrategy;
        this.storageDao = storageDao;
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.execute(transaction, storageDao);
        }
    }
}
