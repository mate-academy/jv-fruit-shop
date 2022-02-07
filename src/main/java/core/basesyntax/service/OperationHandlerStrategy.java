package core.basesyntax.service;

import core.basesyntax.model.DailyActivity;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(DailyActivity dailyActivity);
}
