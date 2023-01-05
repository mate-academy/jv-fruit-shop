package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationService;
import core.basesyntax.strategy.impl.PurchaseOperationService;
import core.basesyntax.strategy.impl.ReturnOperationService;
import core.basesyntax.strategy.impl.SupplyOperationService;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static final Map<String, OperationHandler> operations = new HashMap<>();

    static {
        operations.put("BALANCE", new BalanceOperationService());
        operations.put("SUPPLY", new SupplyOperationService());
        operations.put("PURCHASE", new PurchaseOperationService());
        operations.put("RETURN", new ReturnOperationService());
    }

    public OperationHandler getOperationService(FruitTransaction transaction) {
        return operations.get(transaction.getOperation().toString());
    }
}
