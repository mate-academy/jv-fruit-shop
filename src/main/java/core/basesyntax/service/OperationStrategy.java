package core.basesyntax.service;

import core.basesyntax.service.operations.ExpenseOperationHandler;
import core.basesyntax.service.operations.IncomeOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static Map<Operation, OperationHandler> events = new HashMap<>(4);

    static {
        events.put(Operation.RETURN, new IncomeOperationHandler());
        events.put(Operation.BALANCE, new IncomeOperationHandler());
        events.put(Operation.PURCHASE, new ExpenseOperationHandler());
        events.put(Operation.SUPPLY, new IncomeOperationHandler());
    }

    public static OperationHandler getOperationType(Operation operation) {
        return events.get(operation);
    }
}
