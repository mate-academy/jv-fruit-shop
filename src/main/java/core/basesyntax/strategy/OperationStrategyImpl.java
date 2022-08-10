package core.basesyntax.strategy;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> STRATEGIES = new HashMap<>();

    @Override
    public OperationHandler getStrategy(FruitTransaction transaction) {
        return STRATEGIES.get(transaction.getOperation());
    }

    static {
        STRATEGIES.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(new FruitDaoImpl()));
        STRATEGIES.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(new FruitDaoImpl()));
        STRATEGIES.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(new FruitDaoImpl()));
        STRATEGIES.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(new FruitDaoImpl()));
    }
}
