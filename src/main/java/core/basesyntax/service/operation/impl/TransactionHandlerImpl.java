package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.TransactionHandler;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    @Override
    public void parse(List<FruitTransaction> fruitTransactionList,
                      OperationStrategy operationStrategy) {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransactionList.get(i)
                    .getOperation());
            operationHandler.operation(fruitTransactionList.get(i));
        }
    }
}
