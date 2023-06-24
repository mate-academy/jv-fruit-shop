package core.basesyntax.stragegyfactory;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.BalanceService;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseService;
import core.basesyntax.service.strategy.ReturnService;
import core.basesyntax.service.strategy.SupplyService;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private final Map<FruitTransaction.Operation, OperationHandler> strategy;

    public StrategyFactory() {
        strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.BALANCE,
                new BalanceService());
        strategy.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseService());
        strategy.put(FruitTransaction.Operation.RETURN,
                new ReturnService());
        strategy.put(FruitTransaction.Operation.SUPPLY,
                new SupplyService());
    }

    public Map<FruitTransaction.Operation, OperationHandler> getStrategy() {
        return strategy;
    }

    public OperationHandler getFruitService(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }

}
