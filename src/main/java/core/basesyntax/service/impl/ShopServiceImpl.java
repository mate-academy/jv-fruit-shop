package core.basesyntax.service.impl;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final ShopStorage storage;

    public ShopServiceImpl(OperationStrategy strategy, ShopStorage storage) {
        this.strategy = strategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions must not be null");
        }
        transactions
                .forEach(transaction -> {
                    strategy.get(transaction.getOperation()).handle(transaction, storage);
                });
    }
}
