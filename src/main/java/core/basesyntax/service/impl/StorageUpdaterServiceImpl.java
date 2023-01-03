package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageUpdaterService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StorageUpdaterServiceImpl implements StorageUpdaterService {
    private OperationStrategy strategy;

    public StorageUpdaterServiceImpl() {
        strategy = new OperationStrategy();
    }

    @Override
    public void updateStorage(List<FruitTransaction> fruitTransactions) {
        OperationService storageService;
        for (FruitTransaction transaction : fruitTransactions) {
            storageService = strategy.getOperationService(transaction);
            storageService.updateStorage(transaction);
        }
    }
}
