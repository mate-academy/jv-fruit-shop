package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitShopStrategy {
    void handle(FruitTransaction fruitTransaction);
}
