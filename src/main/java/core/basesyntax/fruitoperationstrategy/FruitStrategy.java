package core.basesyntax.fruitoperationstrategy;

import core.basesyntax.operations.Operation;
import core.basesyntax.service.operationwithdata.FruitOperationService;

public interface FruitStrategy {
    FruitOperationService get(Operation operation);
}
