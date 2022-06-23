package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class AvailableOperationsMap {
    private static Map<String, Transaction.Operation> operationsMap = new HashMap<>();

    static {
        for (Transaction.Operation enumOperation : Transaction.Operation.values()) {
            operationsMap.put(enumOperation.getAbbreviature(), enumOperation);
        }
    }

    public static Map<String, Transaction.Operation> getOperationsMap() {
        return operationsMap;
    }
}
