package service;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationService> serviceMap = new HashMap<>();

    public OperationStrategy() {
        serviceMap.put("b", new BalanceService());
        serviceMap.put("s", new SupplyService());
        serviceMap.put("p", new PurchaseService());
        serviceMap.put("r", new ReturnService());
    }

    public OperationService getOperationService(String service) {
        OperationService operationService = serviceMap.get(service);
        if (operationService == null) {
            throw new IllegalArgumentException("Unknown service type " + service);
        }
        return operationService;
    }
}
