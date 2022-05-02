package strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();

    {
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
    }

    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
