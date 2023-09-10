package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final HandlerStrategy handlerStrategy;

    public OperationProcessImpl(HandlerStrategy handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler
                    = handlerStrategy.get(fruitTransaction.getOperation());
            operationHandler.execute(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
