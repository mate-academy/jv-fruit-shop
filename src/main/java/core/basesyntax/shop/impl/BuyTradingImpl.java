package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;

public class BuyTradingImpl implements Trading {
    @Override
    public void trade(Storage storage, Fruit fruit) {
        if (storage == null || fruit == null) {
            throw new NullPointerException();
        }
        storage.remove(fruit);
    }
}
