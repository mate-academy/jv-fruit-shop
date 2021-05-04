package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;

public class OperationsStrategyImpl implements OperationsStrategy {
    @Override
    public Integer getStrategy(Operation operation) {
        int output = 0;
        if ("s".equals(operation.getOperationType()) || "r".equals(operation.getOperationType())) {
            output = operation.getCount();
        } else {
            output = operation.getCount() * -1;
        }
        return output;
    }
}
