package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public interface OperationHandler {
    void updateDB(String fruit, int quantity, Storage storage);
}
