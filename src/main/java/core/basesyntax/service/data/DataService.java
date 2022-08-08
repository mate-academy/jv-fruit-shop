package core.basesyntax.service.data;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface DataService<T> {
    void processData(List<T> list, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap);
}
