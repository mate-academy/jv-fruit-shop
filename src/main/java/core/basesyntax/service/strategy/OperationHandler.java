package core.basesyntax.service.strategy;

import core.basesyntax.model.DailyActivity;

public interface OperationHandler {
    boolean operation(DailyActivity dailyActivity);
}
