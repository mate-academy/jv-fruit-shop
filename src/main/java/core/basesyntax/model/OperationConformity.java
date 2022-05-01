package core.basesyntax.model;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationConformity {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerConformity = new HashMap<>();

    public OperationConformity() {
        fillOperationConformity();
    }

    public OperationHandler getHandlerByOperation(FruitTransaction.Operation operation) {
        if (!operationHandlerConformity.containsKey(operation)) {
            throw new RuntimeException("Invalid operation submitted");
        }
        return operationHandlerConformity.get(operation);
    }

    private void fillOperationConformity() {
        operationHandlerConformity.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerConformity.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerConformity.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerConformity.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
    }
}
