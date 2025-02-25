package strategy;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.OperationHandler;
import service.impl.BalanceHandler;
import service.impl.PurchaseHandler;
import service.impl.ReturnHandler;
import service.impl.SupplyHandler;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> serviceMap = new HashMap<>();

    public OperationStrategy() {
        serviceMap.put(Operation.BALANCE, new BalanceHandler());
        serviceMap.put(Operation.SUPPLY, new SupplyHandler());
        serviceMap.put(Operation.PURCHASE, new PurchaseHandler());
        serviceMap.put(Operation.RETURN, new ReturnHandler());
    }

    public OperationHandler getOperationService(Operation operation) {
        OperationHandler operationHandler = serviceMap.get(operation);
        if (operationHandler == null) {
            throw new IllegalArgumentException("Unknown service type " + operation);
        }
        return operationHandler;
    }

    public Operation getOperationFromCode(String code) {
        try {
            return Operation.fromCode(code);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid operation code: " + code, e);
        }
    }
}
