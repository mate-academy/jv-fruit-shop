package core.basesyntax.service.operations;

import core.basesyntax.template.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
