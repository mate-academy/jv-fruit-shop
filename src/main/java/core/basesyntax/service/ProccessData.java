package core.basesyntax.service;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ProccessData {
    void handleOperations(List<FruitTransaction> fruitTransactions,
                          Map<FruitTransaction.Operation, OperationHandler> mapOfHandler);
}
