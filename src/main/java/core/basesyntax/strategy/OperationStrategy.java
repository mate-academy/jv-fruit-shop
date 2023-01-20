package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {

    private final Map<String, OperationHandler> operationStrategyMap = new HashMap<>();

    public OperationStrategy() {
        operationStrategyMap.put("p",new PurchaseOperationHandler());
        operationStrategyMap.put("s",new SupplyOperationHandler());
        operationStrategyMap.put("r",new ReturnOperationHandler());
        operationStrategyMap.put("b",new BalanceOperationHandler());
    }

    public OperationHandler getOperationHandler(String operation) {
        return operationStrategyMap.get(operation);
    }
}
