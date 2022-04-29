package strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    public OperationHandler get(String operation) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        return operationHandlerMap.get(operation);
    }
}
