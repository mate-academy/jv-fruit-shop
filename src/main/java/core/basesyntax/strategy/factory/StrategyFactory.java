package core.basesyntax.strategy.factory;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private static final Map<Operation, OperationStrategy> strategies = new HashMap<>();

    static {
        strategies.put(Operation.BALANCE, new BalanceStrategy());
        strategies.put(Operation.SUPPLY, new SupplyStrategy());
        strategies.put(Operation.PURCHASE, new PurchaseStrategy());
        strategies.put(Operation.RETURN, new ReturnStrategy());
    }

    public static OperationStrategy getStrategy(Operation operation) {
        return strategies.get(operation);
    }
}
