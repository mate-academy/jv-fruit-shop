package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.storage.Storage;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage=storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                .getOperationHandlers(transaction.getOperation())
                .transaction(transaction, storage.getFruits()));
    }
}
