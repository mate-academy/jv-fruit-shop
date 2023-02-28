package core.basesyntax.stragegyfactory;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.AddingToBalanceService;
import core.basesyntax.service.strategy.RemovingFromBalanceService;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private final Map<FruitTransaction.Operation, FruitService> strategy;

    public StrategyFactory() {
        strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.BALANCE,
                new AddingToBalanceService());
        strategy.put(FruitTransaction.Operation.PURCHASE,
                new RemovingFromBalanceService());
        strategy.put(FruitTransaction.Operation.RETURN,
                new AddingToBalanceService());
        strategy.put(FruitTransaction.Operation.SUPPLY,
                new AddingToBalanceService());
    }

    public Map<FruitTransaction.Operation, FruitService> getStrategy() {
        return strategy;
    }

    public FruitService getFruitService(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }

}
