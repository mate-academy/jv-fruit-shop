package mate.academy.strategy;

import mate.academy.model.FruitTransaction;
import mate.academy.strategy.activities.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(FruitTransaction.Operation operation);
}
