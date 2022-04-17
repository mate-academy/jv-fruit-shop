package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyOperation {
    public void handle(FruitTransaction fruitTransaction);

}
