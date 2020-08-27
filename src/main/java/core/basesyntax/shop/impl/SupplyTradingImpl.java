package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class SupplyTradingImpl implements Trading {
    private Storage storage;

    public SupplyTradingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void trade(Fruit fruit) {
        if (storage == null || fruit == null) {
            throw new NullPointerException();
        }
        storage.add(fruit);
    }
}
