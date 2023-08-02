package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class FruitShopDataProcessingService implements DataProcessingService {
    private OperationStrategy operationStrategy;

    public FruitShopDataProcessingService(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.completeOperation(transaction);
        }
    }
}
