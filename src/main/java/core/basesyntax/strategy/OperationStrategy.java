package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public interface OperationStrategy {
    OperationService get(FruitTransaction.Operation operation);
}
