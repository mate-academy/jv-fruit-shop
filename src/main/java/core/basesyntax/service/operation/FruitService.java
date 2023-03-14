package core.basesyntax.service.operation;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.model.FruitTransaction;

public interface FruitService {
    Storage storage = new Storage();
    void apply(FruitTransaction fruitTransaction);

}
