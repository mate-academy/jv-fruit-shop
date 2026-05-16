package core.strategy;

import core.db.Storage;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Storage storage);
}
