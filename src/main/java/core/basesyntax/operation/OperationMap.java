package core.basesyntax.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationMap {
    private final Map<Operations, Operation> operationMap;

    public OperationMap() {
        operationMap = new HashMap<>();
        operationMap.put(Operations.BALANCE, new BalanceOperation());
        operationMap.put(Operations.PURCHASE, new PurchaseOperation());
        operationMap.put(Operations.SUPPLY, new SupplyOperation());
        operationMap.put(Operations.RETURN, new ReturnOperation());
    }

    public Map<Operations, Operation> getOperationMap() {
        return operationMap;
    }
}
