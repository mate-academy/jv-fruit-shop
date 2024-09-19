package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy strategy;
    private Storage storage;

    public ShopServiceImpl(OperationStrategy strategy, Storage storage) {
        this.strategy = strategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            try {
                strategy.chooseHandler(transaction).handle(storage, transaction);
            } catch (RuntimeException e) {
                throw new RuntimeException("Error processing transaction: " + e.getMessage());
            }
        }
    }

    @Override
    public Storage getStorage() {
        return storage;
    }
}
