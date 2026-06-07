package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.handler.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.strategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler
                    = strategy.operationHandler(transaction.getOperation());
            operationHandler.handle(transaction, storage);
        }
    }
}
