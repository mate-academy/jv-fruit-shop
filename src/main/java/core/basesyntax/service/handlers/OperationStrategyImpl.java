package core.basesyntax.service.handlers;

import core.basesyntax.model.Transaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl() {
        operationHandlersMap = new HashMap<>() {{
                put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
                put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
                put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());
                put(Transaction.Operation.RETURN, new ReturnOperationHandler());
            }};
    }

    @Override
    public OperationHandler get(Transaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
