package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessServiceImpl implements ProcessService {
    private final OperationStrategy operationStrategy;

    public ProcessServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Storage processObjects(List<FruitTransaction> data) {
        Storage storage = new Storage();
        for (FruitTransaction transaction : data) {
            operationStrategy.get(transaction).perform(transaction, storage);
        }
        return storage;
    }
}
