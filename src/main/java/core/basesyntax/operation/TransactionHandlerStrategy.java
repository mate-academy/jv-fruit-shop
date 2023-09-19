package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public interface TransactionHandlerStrategy {
    TransactionHandler get(FruitTransaction.Operation operation,
                  Map<FruitTransaction.Operation, TransactionHandler> operationMap);
}
