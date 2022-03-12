package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationHandler {
    private Map<String, Operation> operationMap;

    public OperationHandler() {
        operationMap = new HashMap<>();
        putOperations();
    }

    public Map<String, Operation> getOperations() {
        return operationMap;
    }

    private void putOperations() {
        operationMap.put(OperationType.BALANCE.getOperation(),
                new BalanceOperation());
        operationMap.put(OperationType.SUPPLY.getOperation(),
                new SupplyOperation());
        operationMap.put(OperationType.PURCHASE.getOperation(),
                new PurchaseOperation());
        operationMap.put(OperationType.RETURN.getOperation(),
                new ReturnOperation());
    }
}
