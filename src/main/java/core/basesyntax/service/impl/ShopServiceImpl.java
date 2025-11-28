package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Objects; // Додано імпорт

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = Objects
                .requireNonNull(operationStrategy, "Operation strategy cannot be null");
        this.storage = Objects
                .requireNonNull(storage, "Storage cannot be null");
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        Objects.requireNonNull(transactions, "Transactions list cannot be null");
        for (FruitTransaction transaction : transactions) {
            Objects.requireNonNull(transaction, "Transaction cannot be null");
            FruitTransaction.Operation operation = transaction.getOperation();

            OperationHandler operationHandler = operationStrategy.getOperationHandler(operation);

            String fruitName = transaction.getFruit();
            int currentQuantity = storage.get(fruitName);
            int newQuantity = operationHandler.handle(transaction, currentQuantity);
            storage.put(fruitName, newQuantity);
        }
    }
}
