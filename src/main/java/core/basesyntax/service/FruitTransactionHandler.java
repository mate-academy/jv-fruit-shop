package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface FruitTransactionHandler {
    void handle(FruitTransaction fruitTransaction, Storage storage);
}
