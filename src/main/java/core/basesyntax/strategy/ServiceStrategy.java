package core.basesyntax.strategy;

import core.basesyntax.operation.Activity;
import core.basesyntax.service.activity.ActivityService;

public interface ServiceStrategy {
    ActivityService get(Activity activity);
}
