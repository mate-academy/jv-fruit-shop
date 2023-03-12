package core.basesyntax.strategy.impl;

import core.basesyntax.exception.FruitStoreException;
import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.strategy.ApplayStrategy;

public class ApplayStrategyImpl implements ApplayStrategy {
    @Override
    public void process(FruitNegotiation fruit) {
        switch (fruit.getOperation()) {
            case BALANCE:
                new ApplayBalance(fruit).applay();
                break;
            case PURCHASE:
                new ApplayPurchase(fruit).applay();
                break;
            case RETURN:
                new ApplayReturn(fruit).applay();
                break;
            case SUPPLY:
                new ApplaySupplay(fruit).applay();
                break;
            default:
                throw new FruitStoreException("Missing type of operation " + fruit.getOperation());
        }
    }
}
