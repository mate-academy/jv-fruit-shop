package core.basesyntax.model;

import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.strategy.TransactionStrategyPurchaseImpl;
import core.basesyntax.strategy.TransactionStrategyReturnImpl;
import core.basesyntax.strategy.TransactionStrategySupplyImpl;

public class FruitTransaction {
    public TransactionStrategy getStrategy(String operation) {
        switch (operation) {
            case "s":
                return new TransactionStrategySupplyImpl();
            case "r":
                return new TransactionStrategyReturnImpl();
            case "p":
                return new TransactionStrategyPurchaseImpl();
            case "b":
            default:
                return new TransactionStrategyImpl();
        }
    }

}
