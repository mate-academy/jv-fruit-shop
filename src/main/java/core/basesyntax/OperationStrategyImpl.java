package core.basesyntax;

import core.basesyntax.handler.*;

import java.util.*;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void handle(FruitTransaction transaction,
                                  Map<String, Integer> storage) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());

        if (handler == null) {
            throw new IllegalArgumentException(
                    "No handler for: " + transaction.getOperation());
        }

        handler.handle(transaction, storage);
    }
}

