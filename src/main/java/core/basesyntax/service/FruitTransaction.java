package core.basesyntax.service;

import core.basesyntax.operation.Operation;
import core.basesyntax.service.activity.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitTransaction {
    void processTransaction(List<String> listFromFile,
                     Map<Operation, OperationHandler> activityServiceMap);
}
