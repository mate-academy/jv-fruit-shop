package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperatorStrategy;

public class OperatorStrategyImpl implements OperatorStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperatorStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                        operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlerMap() {
        return operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        return operationHandlerMap.get(transaction.getOperation());
    }
}
