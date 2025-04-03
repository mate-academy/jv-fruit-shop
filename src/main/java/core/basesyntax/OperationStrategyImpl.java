package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(transaction);
        } else {
            throw new UnsupportedOperationException("Операція не підтримується: "
                    + transaction.getOperation());
        }
    }
}
