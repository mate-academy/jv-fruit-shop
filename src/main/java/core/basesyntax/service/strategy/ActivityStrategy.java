package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.handler.ActivityHandler;

public interface ActivityStrategy {

    ActivityHandler get(Operation operation);
}
