package core.basesyntax.fruitoperation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public interface Operation {
    void doOperation(Storage storage, Fruit fruit, int amount);
}
