package core.service.impl;

import core.db.Storage;
import core.service.ShopService;
import core.strategy.FruitTransaction;
import core.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategy.get(t.getOperation()).handle(t,storage));

    }
}
