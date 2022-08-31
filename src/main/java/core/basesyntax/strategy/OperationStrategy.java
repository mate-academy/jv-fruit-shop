package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    public static final Map<Transaction.Operation, OperationHandler> operationMap = new HashMap<>();
}
