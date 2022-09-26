package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
     OperationHandler chooseOperation(Operation operation);
}
