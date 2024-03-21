package core.basesyntax.service.strategy;

import core.basesyntax.exceptions.ServiceNotExistsException;
import core.basesyntax.models.Operation;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> services;

    public OperationStrategy(Map<String, OperationHandler> services) {
        this.services = services;
    }

    public OperationHandler getOperation(Operation activityType) {
        OperationHandler service = services.get(activityType.getCode());
        if (service == null) {
            throw new ServiceNotExistsException("There is no such service implemented: "
                    + activityType.name());
        }
        return service;
    }
}
