package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(FruitTransaction.Operation operation);
}
