package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler == null) {
                throw new IllegalArgumentException("No handler for operation: "
                        + transaction.getOperation());
            }
            handler.apply(transaction);
        }
    }
}
