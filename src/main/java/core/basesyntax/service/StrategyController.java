package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitShopStrategy;

public interface StrategyController {
    void setStrategy(FruitTransaction.Operation key, FruitShopStrategy strategy);
    FruitShopStrategy getStrategy(FruitTransaction.Operation key);
}
