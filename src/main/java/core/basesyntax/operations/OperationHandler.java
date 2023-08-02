package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public interface OperationHandler {
    void handle(String fruit, int quantity, Storage storage);
}
