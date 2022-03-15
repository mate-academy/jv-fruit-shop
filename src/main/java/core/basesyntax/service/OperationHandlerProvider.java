package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerProvider {
    private final Map<String, OperationHandler> operationMap;

    public OperationHandlerProvider() {
        operationMap = new HashMap<>();
        putOperations();
    }

    public Map<String, core.basesyntax.service.operation.OperationHandler> getOperationHandlers() {
        return operationMap;
    }

    private void putOperations() {
        operationMap.put(OperationType.BALANCE.getOperation(),
                new BalanceOperationHandler());
        operationMap.put(OperationType.SUPPLY.getOperation(),
                new SupplyOperationHandler());
        operationMap.put(OperationType.PURCHASE.getOperation(),
                new PurchaseOperationHandler());
        operationMap.put(OperationType.RETURN.getOperation(),
                new ReturnOperationHandler());
    }
}
