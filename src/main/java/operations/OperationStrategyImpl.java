package operations;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operation> operationMap;

    public OperationStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(String firstLetter) {
        return operationMap.get(firstLetter);
    }
}
