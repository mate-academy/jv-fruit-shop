package core.basesyntax.service;

import core.basesyntax.model.Type;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public interface FruitService {
    void createReport(Map<Type, OperationHandler> operationHandlerMap);
}
