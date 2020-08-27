package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class BuyTradingImpl implements Trading {
    private Storage storage;

    public BuyTradingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void trade(Fruit fruit) {
        if (storage == null || fruit == null) {
            throw new NullPointerException("Passed parameter is null");
        }
        storage.remove(fruit);
    }
}
