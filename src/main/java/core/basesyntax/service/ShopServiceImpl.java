package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.Objects;

public class ShopServiceImpl implements ShopService {
    private final OperationsStrategy operationsStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationsStrategy operationsStrategy, Storage storage) {
        this.operationsStrategy = Objects.requireNonNull(operationsStrategy,
                "operationsStrategy is null");
        this.storage = Objects.requireNonNull(storage, "storage is null");
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions list is null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction is null");
            }
            OperationHandler handler = operationsStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }

    public Storage getStorage() {
        return storage;
    }
}
