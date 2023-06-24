package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandler.OperationHandler;
import java.util.List;
import java.util.Map;

public interface ProcessDataService {
    void processData(List<String> data, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap);
}
