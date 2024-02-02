package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationCompiler {
    void doOperation(FruitTransaction fruitTransaction);
}
