package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public interface Operation {
    void performOperation(Storage storage, FruitTransaction fruitTransaction);
}
