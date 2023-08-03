package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.OperationHandler;

public interface OperatorStrategy {
    OperationHandler getOperatorHandler(FruitTransaction.Operation operator);
}
