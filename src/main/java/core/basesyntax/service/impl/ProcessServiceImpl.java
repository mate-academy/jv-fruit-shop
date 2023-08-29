package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class ProcessServiceImpl implements ProcessService {
    @Override
    public void processData(List<FruitTransaction> fruitTransactionList,
                            OperationStrategy operationStrategy) {
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
