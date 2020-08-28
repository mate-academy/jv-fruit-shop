package core.basesyntax.shop.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class RefundsTradingImpl implements Trading {
    private Storage storage;

    public RefundsTradingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void trade(Fruit fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("The passed argument is null");
        }
        storage.add(fruit, quantity);
    }
}
