package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.storage = new Storage(new HashMap<>());

    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction tx : transactions) {
            strategy.getHandler(tx.getOperation()).handle(storage.getStorage(), tx);
        }
    }

    @Override
    public Storage getStorage() {
        return storage;
    }
}
