package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction fruitTransaction);
}
