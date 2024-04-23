package core.basesyntax.service.storage;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private OperationStrategy operationStrategy;
    private FruitStorage storage;

    public StorageServiceImpl(OperationStrategy operationStrategy, FruitStorage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions, FruitStorage storage) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.process(transaction, storage);
        }
    }
}
