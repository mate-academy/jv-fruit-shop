package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;

public class Strategy {
    public StrategyCalculator getStrategy(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case SUPPLY:
                return new SupplyHandler();
            case RETURN:
                return new ReturnHandler();
            case PURCHASE:
                return new PurchaseHandler();
            default:
                return new BalanceHandler();
        }
    }
}
