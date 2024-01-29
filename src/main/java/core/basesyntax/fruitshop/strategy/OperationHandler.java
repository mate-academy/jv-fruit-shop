package core.basesyntax.fruitshop.strategy;

import core.basesyntax.fruitshop.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
