package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl {
    private static Map<FruitTransaction.Operation, OperationStrategy> strategies = new HashMap<>();

    static {
        strategies = Map.of(
                FruitTransaction.Operation.BALANCE,
                        new BalanceOperationStrategy(),
                FruitTransaction.Operation.PURCHASE,
                        new PurchaseOperationStrategy(),
                FruitTransaction.Operation.RETURN,
                        new ReturnOperationStrategy(),
                FruitTransaction.Operation.SUPPLY,
                        new SupplyOperationStrategy()
        );
    }

    public OperationStrategy getOperationStrategy(FruitTransaction transaction) {
        return strategies.get(transaction.getOperation());
    }
}
