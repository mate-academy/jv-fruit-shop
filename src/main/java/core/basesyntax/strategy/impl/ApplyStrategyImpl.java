package core.basesyntax.strategy.impl;

import core.basesyntax.exception.FruitStoreException;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.ApplyStrategy;

public class ApplyStrategyImpl implements ApplyStrategy {
    @Override
    public void process(FruitNegotiation fruit) {
        switch (fruit.getOperation()) {
            case BALANCE:
                new ApplyBalance(fruit).apply();
                break;
            case PURCHASE:
                new ApplyPurchase(fruit).apply();
                break;
            case RETURN:
                new ApplyReturn(fruit).apply();
                break;
            case SUPPLY:
                new ApplySupplay(fruit).apply();
                break;
            default:
                throw new FruitStoreException("Missing type of operation " + fruit.getOperation());
        }
    }
}
