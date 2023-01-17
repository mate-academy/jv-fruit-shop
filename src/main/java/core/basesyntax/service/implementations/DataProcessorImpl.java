package core.basesyntax.service.implementations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {

    private StorageDao storageDao;
    private OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy, StorageDao storageDao) {
        this.operationStrategy = operationStrategy;
        this.storageDao = storageDao;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransaction) {

        for (FruitTransaction transaction : fruitTransaction) {
            OperationHandler operationHandler =
                            operationStrategy.get(transaction.getOperation());
            operationHandler.makeOperation(transaction.getFruit(),
                    transaction.getQuantity(), storageDao);
        }
    }
}
