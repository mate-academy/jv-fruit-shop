package core.basesyntax.strategy;

import core.basesyntax.Operation;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    Map<Operation, OperationHandler> operationStrategyrMap;
    {
        operationStrategyrMap = new HashMap<>();
        operationStrategyrMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyrMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationStrategyrMap.put(Operation.RETURN, new ReturnHandler());
        operationStrategyrMap.put(Operation.SUPPLY, new SupplyHandler());
    }
    public OperationHandler getOperationHandler(Operation operation) {
        return operationStrategyrMap.get(operation);
    }
}
