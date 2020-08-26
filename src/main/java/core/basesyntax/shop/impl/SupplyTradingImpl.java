package core.basesyntax.shop.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.Storage;
import core.basesyntax.shop.Trading;

public class SupplyTradingImpl implements Trading {
    @Override
    public void trade(Storage storage, Fruit fruit) {
        storage.add(fruit);
    }
}
