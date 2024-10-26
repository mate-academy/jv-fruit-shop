package core.basesyntax.operationstrategy;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    void applyOperation(Operation operation, String fruit, int quantity);
}
