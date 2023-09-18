package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public OperationProcessImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler
                    = operationHandlerStrategy.get(fruitTransaction.getOperation());
            operationHandler.execute(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
