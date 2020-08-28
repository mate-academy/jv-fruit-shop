package core.basesyntax.service.impl;

import core.basesyntax.daily.Fruit;
import core.basesyntax.daily.Storage;

public class SalesFruit implements StockChangeable {
    private Storage storage;

    @Override
    public void apply(Fruit fruit) {
        Storage str = new Storage();
        str.remove(fruit);
    }
}
