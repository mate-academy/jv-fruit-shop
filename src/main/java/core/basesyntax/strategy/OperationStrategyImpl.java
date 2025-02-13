package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void strategy(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        OperationHandler handler = operationHandlers.get(fruitTransaction.getOperation());
        handler.handle(fruitTransaction, fruitStorage);
    }
}
