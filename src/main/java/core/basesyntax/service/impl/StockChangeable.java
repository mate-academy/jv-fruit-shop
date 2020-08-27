package core.basesyntax.service.impl;

import core.basesyntax.daily.Fruit;

public interface StockChangeable {
    public void apply(Fruit fruit);
}
