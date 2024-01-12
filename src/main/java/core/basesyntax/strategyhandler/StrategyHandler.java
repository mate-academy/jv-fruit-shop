package core.basesyntax.strategyhandler;

import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.ShopStrategy;

public interface StrategyHandler {
    ShopStrategy strategyHandler(FruitTransaction.Operation operation);
}
