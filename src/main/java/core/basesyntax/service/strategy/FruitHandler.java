package core.basesyntax.service.strategy;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.model.FruitTransaction;

public interface FruitHandler {
    Storage storage = new Storage();
    void apply(FruitTransaction fruitTransaction);
}
