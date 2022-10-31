package service.activity.strategy.strategy.impl;

import service.activity.strategy.DoActivities;
import service.activity.strategy.StrategyOfActivities;

public class StrategyOfActivitiesImpl implements StrategyOfActivities {
    private static final String BALACE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public DoActivities rightActivity(String activity) {
        switch (activity) {
            case BALACE:
                return new BalaceReadActivity();
            case SUPPLY:
                return new SupplyActivity();
            case PURCHASE:
                return new PurchaseActivity();
            case RETURN:
                return new ReturnActivity();
            default:
                throw new RuntimeException("No such activity found!");
        }
    }
}
