package core.basesyntax.fruittransact.strategy;

import core.basesyntax.fruittransact.FruitService;

public interface FruitTransactionStrategy {
    FruitService get(String type);
}
