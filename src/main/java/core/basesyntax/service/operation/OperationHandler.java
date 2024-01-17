package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer handle(FruitTransaction fruitTransaction, Storage storage);
}
