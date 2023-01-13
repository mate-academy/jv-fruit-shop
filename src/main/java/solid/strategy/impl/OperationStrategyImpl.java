package solid.strategy.impl;

import java.util.Map;
import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strategy.OperationStrategy;
import solid.strategy.impl.operation.BalanceOperationHandler;
import solid.strategy.impl.operation.PurchaseOperationHandler;
import solid.strategy.impl.operation.ReturnOperationHandler;
import solid.strategy.impl.operation.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        operationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        );
        return operationHandlerMap.get(operation);
    }
}
