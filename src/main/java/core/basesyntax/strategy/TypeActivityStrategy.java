package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.amount.ActivityHandler;

public interface TypeActivityStrategy {
    ActivityHandler get(Operation operation);
}
