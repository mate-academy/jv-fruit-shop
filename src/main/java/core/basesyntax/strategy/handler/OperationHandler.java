package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    boolean handle(FruitTransaction fruitTransaction);
}
