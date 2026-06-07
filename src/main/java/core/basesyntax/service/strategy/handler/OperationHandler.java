package core.basesyntax.service.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction, Storage storage);
}
