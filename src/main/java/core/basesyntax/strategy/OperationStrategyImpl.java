package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void process(FruitTransaction transaction) {
        FruitTransaction.Operation operation = transaction.getOperation();
        OperationHandler handler = handlerMap.get(operation);

        if (handler == null) {
            throw new RuntimeException(
                    "No handler found for operation: " + operation
            );
        }

        handler.apply(transaction.getFruit(), transaction.getQuantity());
    }
}
