package core.basesyntax.service.impl;

import core.basesyntax.Storage;
import core.basesyntax.daily.Fruit;

public class AddingFruit implements StockChangeable {
    private Storage storage;

    @Override
    public void apply(Fruit fruit) {
        Storage str = new Storage();
        str.add(fruit);
    }
}
