package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.serviceimpl.operationhandlers.OperationHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}
