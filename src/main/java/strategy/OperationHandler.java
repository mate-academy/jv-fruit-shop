package strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Storage storage);
}
