package core.basesyntax.service.impl;

import core.basesyntax.daily.Fruit;

public interface StockChangeable {
    void apply(Fruit fruit);
}
