package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operations = new HashMap<>();

    static {
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    }

    public OperationHandler getHandler(FruitTransaction transaction) {
        return operations.get(transaction.getOperation());
    }
}
