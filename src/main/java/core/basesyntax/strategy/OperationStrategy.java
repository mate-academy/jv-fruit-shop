package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public interface OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> operationHashMap = new HashMap<>();
    FruitTransaction.Operation getOperation(FruitTransaction transaction,
                                            Map<FruitTransaction.Operation,
                                                    OperationHandler> operationHashMap);

}
