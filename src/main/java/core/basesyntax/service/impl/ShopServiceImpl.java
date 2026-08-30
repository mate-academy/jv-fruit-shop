package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        Map<String, Integer> storage = Storage.internalMapForService();
        for (FruitTransaction tx : transactions) {
            storage.putIfAbsent(tx.getFruit(), 0);
            strategy.apply(tx, storage);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.getSnapshot();
    }
}
