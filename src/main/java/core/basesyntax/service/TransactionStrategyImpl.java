package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                           operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getActivity(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
