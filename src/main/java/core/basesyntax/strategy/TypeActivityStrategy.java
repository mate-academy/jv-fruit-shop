package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.amount.ActivityHandler;

public interface TypeActivityStrategy {
    ActivityHandler get(FruitTransaction.Operation operation);
}
