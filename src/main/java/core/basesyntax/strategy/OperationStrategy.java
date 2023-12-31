package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.operation.InputOperation;

public interface OperationStrategy {
    InputOperation get(FruitOperation.Operation operation);
}
