package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class RefundsTradingImpl implements Trading {
    private Storage storage;

    public RefundsTradingImpl(Storage storage) {
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
