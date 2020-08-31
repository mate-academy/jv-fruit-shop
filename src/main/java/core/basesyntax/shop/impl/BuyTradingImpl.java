package core.basesyntax.shop.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class BuyTradingImpl implements Trading {
    private Storage storage;

    public BuyTradingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void trade(Fruit fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("Expected to receive fruit, but got null");
        }
        storage.remove(fruit, quantity);
    }
}
