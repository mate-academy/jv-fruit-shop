package core.basesyntax.service;

import core.basesyntax.service.operations.Expense;
import core.basesyntax.service.operations.Income;
import core.basesyntax.service.operations.OperationService;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static Map<Operation, OperationService> events = new HashMap<>(4);

    static {
        events.put(Operation.RETURN, new Expense());
        events.put(Operation.BALANCE, new Income());
        events.put(Operation.PURCHASE, new Expense());
        events.put(Operation.SUPPLY, new Income());
    }

    public static OperationService getOperationType(Operation operation) {
        return events.get(operation);
    }
}
