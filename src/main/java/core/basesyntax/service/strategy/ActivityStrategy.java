package core.basesyntax.service.strategy;

import core.basesyntax.exceptions.ServiceNotExistsException;
import core.basesyntax.utility.FruitTransaction;
import java.util.Map;

public class ActivityStrategy {
    private final Map<String, ActivityService> services;

    public ActivityStrategy(Map<String, ActivityService> services) {
        this.services = services;
    }

    public ActivityService getActivityService(FruitTransaction.Operation activityType) {
        ActivityService service = services.get(activityType.getCode());
        if (service == null) {
            throw new ServiceNotExistsException("There is no such service implemented: "
                    + activityType.name());
        }
        return service;
    }
}
