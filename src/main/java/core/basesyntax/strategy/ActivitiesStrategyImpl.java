package core.basesyntax.strategy;

import core.basesyntax.constants.Activities;
import core.basesyntax.strategy.handlers.ActivitiesHandler;
import core.basesyntax.strategy.handlers.impl.BalanceActivityHandler;
import core.basesyntax.strategy.handlers.impl.PurchaseActivityHandler;
import core.basesyntax.strategy.handlers.impl.ReturnActivityHandler;
import core.basesyntax.strategy.handlers.impl.SupplyActivityHandler;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    @Override
    public ActivitiesHandler get(Activities activity) {
        switch (activity) {
            case RETURN -> {
                return new ReturnActivityHandler();
            }
            case SUPPLY -> {
                return new SupplyActivityHandler();
            }
            case BALANCE -> {
                return new BalanceActivityHandler();
            }
            case PURCHASE -> {
                return new PurchaseActivityHandler();
            }
            default -> throw new RuntimeException("Incorrect query");
        }
    }
}
