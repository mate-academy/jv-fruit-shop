package strategy;

import java.util.Map;
import model.FruitTransaction;
import operation.OperationHandler;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.TransactionType, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<FruitTransaction.TransactionType,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler process(FruitTransaction.TransactionType transaction) {
        return operationHandlerMap.get(transaction);
    }
}
