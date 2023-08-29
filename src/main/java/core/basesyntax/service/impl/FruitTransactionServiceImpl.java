package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy
                    .getHandler(fruitTransaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("Handler not found for operation: "
                        + fruitTransaction.getOperation());
            }
            handler.operateTransaction(fruitTransaction);
        }
    }
}
