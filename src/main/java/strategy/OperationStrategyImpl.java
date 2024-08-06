package strategy;

import handler.OperationHandler;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(transaction);
        } else {
            throw new RuntimeException("No handler found for operation: "
                    + transaction.getOperation());
        }
    }
}

