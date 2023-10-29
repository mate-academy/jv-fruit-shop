package core.basesyntax.service.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationProcessorService {
    public void process(List<FruitTransaction> transactions, OperationStrategy operationStrategy) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
