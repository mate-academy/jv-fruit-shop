package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class OperationStorage {
    private Map<String, Operation> operationMap;

    public OperationStorage() {
        operationMap = new HashMap<>();
        operationMap.put("s", new Supply());
        operationMap.put("b", new Buy());
        operationMap.put("r", new Return());
    }

    public Map<String, Operation> getOperationMap() {
        return operationMap;
    }
}
