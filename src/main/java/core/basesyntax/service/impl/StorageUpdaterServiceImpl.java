package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageUpdaterService;
import core.basesyntax.strategy.StorageService;
import core.basesyntax.strategy.StorageStrategy;
import java.util.List;

// IDK what is better: either have this class or transfer this logic to StorageStrategy????
public class StorageUpdaterServiceImpl implements StorageUpdaterService {
    private StorageStrategy strategy = new StorageStrategy();

    @Override
    public void updateStorage(List<FruitTransaction> fruitTransactions) {
        StorageService storageService;
        for (FruitTransaction transaction : fruitTransactions) {
            storageService = strategy.getStorageService(transaction);
            storageService.updateStorage(transaction);
        }
    }
}
