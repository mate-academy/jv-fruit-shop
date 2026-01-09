package strategy;

import core.basesyntax.FruitTransaction;
import db.Storage;

public interface OperationHandler {
    void handler(FruitTransaction fruitTransaction, Storage storage);
}
