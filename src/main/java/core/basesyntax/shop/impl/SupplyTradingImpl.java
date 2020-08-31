package core.basesyntax.shop.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class SupplyTradingImpl implements Trading {
    private Storage storage;

    public SupplyTradingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void trade(Fruit fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("Expected to receive fruit, but got null");
        }
        storage.add(fruit, quantity);
    }
}
