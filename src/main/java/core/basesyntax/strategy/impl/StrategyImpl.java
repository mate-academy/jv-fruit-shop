package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Strategy;

public class StrategyImpl implements Strategy {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
                new BalanceOperation().handle(fruitTransaction);
                break;
            case PURCHASE:
                new PurchaseOperationImpl().handle(fruitTransaction);
                break;
            case SUPPLY:
                new SupplyOperationImpl().handle(fruitTransaction);
                break;
            default:
                new ReturnOperationImpl().handle(fruitTransaction);
        }
    }
}
