package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface OperationStrategy {
    void getOperationAndProcess(List<FruitTransaction> transactions,
                                            Map<FruitTransaction.Operation,
                                                    OperationHandler> operationHashMap);
}
