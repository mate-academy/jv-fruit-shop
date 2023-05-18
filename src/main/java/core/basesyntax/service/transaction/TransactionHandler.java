package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public interface TransactionHandler extends FruitInventoryManipulator {
    void handle(FruitTransaction transaction);
}
