package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionStrategy;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}
