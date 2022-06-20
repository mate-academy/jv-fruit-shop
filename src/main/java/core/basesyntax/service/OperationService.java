package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface OperationService {
    void action(Map<FruitTransaction.Operation, OperationHandler> operationHandler,
                List<String> infoFromFile);
}
