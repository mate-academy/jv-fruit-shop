package strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    public Map<String, OperationHandler> buildMap() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        return operationHandlerMap;
    }

    public OperationHandler get(String operation) {
        return buildMap().get(operation);
    }
}
