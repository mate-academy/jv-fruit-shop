package core.basesyntax.service.impl;

import core.basesyntax.daily.Fruit;
import core.basesyntax.daily.Storage;

public class AddingFruit implements StockChangeable {
    private Storage storage;

    @Override
    public void apply(Fruit fruit) {
        Storage.add(fruit);
    }
}
