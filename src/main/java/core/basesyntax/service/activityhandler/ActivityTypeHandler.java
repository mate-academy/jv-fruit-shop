package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.OperationException;

import java.util.Map;

public interface ActivityTypeHandler {
    void processActivity(Map<String, Integer> storage,
                         String fruit, Integer amount) throws OperationException;
}
