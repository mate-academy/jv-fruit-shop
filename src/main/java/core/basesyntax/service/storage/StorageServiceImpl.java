package core.basesyntax.service.storage;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private FruitStorage storage;
    private OperationStrategy operationStrategy;

    public StorageServiceImpl(FruitStorage storage, OperationStrategy operationStrategy) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.process(transaction, storage);
        }
    }
}
