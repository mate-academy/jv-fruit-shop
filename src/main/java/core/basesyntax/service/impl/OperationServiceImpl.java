package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationPerformerStrategy;
import java.util.List;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    private OperationPerformerStrategy strategy;
    private StorageDao storageDao;

    public OperationServiceImpl(OperationPerformerStrategy strategy, StorageDao storageDao) {
        this.strategy = strategy;
        this.storageDao = storageDao;
    }

    @Override
    public Map<Fruit, Integer> processOperations(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            strategy.getOperationPerformer(transaction.getOperation())
                    .perform(transaction);
        }
        return storageDao.getAll();
    }
}
