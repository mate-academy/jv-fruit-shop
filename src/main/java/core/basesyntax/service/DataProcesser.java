package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface DataProcesser {
    void processData(List<FruitTransaction> transactions,
                     Map<Operation, OperationHandler> operationDefiner);
}
