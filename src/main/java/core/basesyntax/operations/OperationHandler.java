package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public interface OperationHandler {

    void handle(Storage storage, FruitTransaction transaction);
}
