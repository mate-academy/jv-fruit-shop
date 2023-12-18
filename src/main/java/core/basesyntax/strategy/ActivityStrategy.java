package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivityStrategy {
    ActivityHandler get(FruitTransaction.Operation operation);
}
