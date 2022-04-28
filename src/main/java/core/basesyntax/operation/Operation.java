package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface Operation {
    Operation proceed(FruitTransaction fruitTransaction);
}
