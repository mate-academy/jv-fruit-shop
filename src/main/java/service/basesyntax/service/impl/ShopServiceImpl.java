package service.basesyntax.service.impl;

import java.util.List;
import service.basesyntax.db.Storage;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.ShopService;
import service.basesyntax.service.strategy.OperationHandler;
import service.basesyntax.service.strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        if (operationStrategy == null) {
            throw new NullPointerException("operationStrategy is null");
        }
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new IllegalArgumentException("transactions is null or empty");
        }
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler handler = operationStrategy.getHandler(operation);
            handler.apply(storage, transaction);
        }
    }
}
