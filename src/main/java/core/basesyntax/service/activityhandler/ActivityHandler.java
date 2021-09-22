package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.ImpossibleOperationException;
import java.util.Map;

public interface ActivityHandler {
    void processActivity(Map<String, Integer> storage,
                         String fruit, Integer amount) throws ImpossibleOperationException;
}
