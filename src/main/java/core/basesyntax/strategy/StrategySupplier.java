package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class StrategySupplier {
    public Strategy getStrategy(FruitTransaction.Operation operationType) {
        return switch (operationType) {
            case BALANCE -> new BalanceStrategy();
            case SUPPLY -> new SupplyStrategy();
            case PURCHASE -> new PurchaseStrategy();
            case RETURN -> new ReturnStrategy();
        };
    }
}
