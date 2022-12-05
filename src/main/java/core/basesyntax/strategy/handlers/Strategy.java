package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface Strategy {
    OperationHandler getHandler(FruitTransaction fruitTransaction);
}
