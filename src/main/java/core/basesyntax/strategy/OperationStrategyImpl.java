package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getStrategy(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }

    public static void initialization(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

    }
}
