package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    void startOperation(OperationType operationType, Fruit fruit);
}
