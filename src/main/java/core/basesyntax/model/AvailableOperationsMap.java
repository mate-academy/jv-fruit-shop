package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class AvailableOperationsMap {

    public static Map<String, Transaction.Operation> operationsMap = new HashMap<>();

    private void populateOperationsMap() {
        for (Transaction.Operation enumOperation : Transaction.Operation.values()) {
            operationsMap.put(enumOperation.getOperation(), enumOperation);
        }
    }


}
