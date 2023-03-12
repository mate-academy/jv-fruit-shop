package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class Strategy {
    public StrategyCalculator getStrategy(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case SUPPLY:
                return new SupplyOperation();
            case RETURN:
                return new ReturnOperation();
            case PURCHASE:
                return new PurchaseOperation();
            default:
                return new BalanceOperation();
        }
    }
}
