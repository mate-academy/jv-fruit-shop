package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;

public interface OperationsStrategy {
    Integer getStrategy(Operation operation);
}
