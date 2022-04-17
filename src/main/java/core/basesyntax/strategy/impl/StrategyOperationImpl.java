package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyOperation;

public class StrategyOperationImpl implements StrategyOperation {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
                new BalanceOperation().handle(fruitTransaction);
                break;
            case PURCHASE:
                new PurchaseOperation().handle(fruitTransaction);
                break;
            case SUPPLY:
                new SupplyOperation().handle(fruitTransaction);
                break;
            default:
                new ReturnOperation().handle(fruitTransaction);
        }
    }
}
