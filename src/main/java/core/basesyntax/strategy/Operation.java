package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface Operation {
    void performOperation(FruitTransaction transaction, FruitStorage fruitStorage);
}
