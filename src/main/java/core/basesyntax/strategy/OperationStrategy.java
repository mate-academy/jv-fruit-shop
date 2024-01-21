package core.basesyntax.strategy;

import core.basesyntax.Operation;
import java.util.Map;

public class OperationStrategy {
    Map<Operation, OperationHandler> operationStrategyrMap;

    public OperationStrategy() {
        this.operationStrategyrMap = Map.of(Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseHandler(), Operation.RETURN, new ReturnHandler(),
                Operation.SUPPLY, new SupplyHandler());
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationStrategyrMap.get(operation);
    }
}
