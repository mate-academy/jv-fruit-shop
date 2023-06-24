package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction transaction);
}
