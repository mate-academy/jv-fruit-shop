package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final OperationStrategy operationStrategy;

    public OperationProcessImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    public void processData(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(
                    transaction.getOperation());
            operationHandler.doOperation(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}
