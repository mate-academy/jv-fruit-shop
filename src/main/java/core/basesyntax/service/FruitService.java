package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public interface FruitService {
    String createReport(Map<OperationType, OperationHandler> operationHandlerMap);
}
