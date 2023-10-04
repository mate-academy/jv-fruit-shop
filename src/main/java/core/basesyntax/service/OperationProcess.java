package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public interface OperationProcess {
    void processData(List<FruitTransaction> transactions,
                     Map<FruitTransaction.Operation, OperationHandler> map);
}
