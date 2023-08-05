package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivities;

public interface OperationStrategy {
    OperationActivities get(FruitTransaction.Operation operation);
}
