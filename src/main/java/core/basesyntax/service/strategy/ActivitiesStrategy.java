package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivitiesStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
