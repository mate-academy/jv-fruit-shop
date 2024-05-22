package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy strategy;
    private Storage storage;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.storage = new StorageImpl();
    }

    @Override
    public Storage process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            try {
                strategy.chooseHandler(transaction).handle(storage, transaction);
            } catch (RuntimeException e) {
                System.err.println("Error processing transaction: " + e.getMessage());
            }
        }
        return storage;
    }
}
