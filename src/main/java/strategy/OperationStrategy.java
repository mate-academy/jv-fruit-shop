package strategy;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.OperationService;
import service.impl.BalanceService;
import service.impl.PurchaseService;
import service.impl.ReturnService;
import service.impl.SupplyService;

public class OperationStrategy {
    private final Map<Operation, OperationService> serviceMap = new HashMap<>();

    public OperationStrategy() {
        serviceMap.put(Operation.BALANCE, new BalanceService());
        serviceMap.put(Operation.SUPPLY, new SupplyService());
        serviceMap.put(Operation.PURCHASE, new PurchaseService());
        serviceMap.put(Operation.RETURN, new ReturnService());
    }

    public OperationService getOperationService(Operation operation) {
        OperationService operationService = serviceMap.get(operation);
        if (operationService == null) {
            throw new IllegalArgumentException("Unknown service type " + operation);
        }
        return operationService;
    }

    public Operation getOperationFromCode(String code) {
        try {
            return Operation.fromCode(code);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid operation code: " + code, e);
        }
    }
}
