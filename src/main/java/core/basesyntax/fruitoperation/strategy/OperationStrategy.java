package core.basesyntax.fruitoperation.strategy;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.Operations;

public interface OperationStrategy {
    Operation get(Operations type);
}
