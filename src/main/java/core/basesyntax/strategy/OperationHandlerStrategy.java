package core.basesyntax.strategy;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler chooseOperation(FruitTransaction.TypeOperation typeOperation);
}
