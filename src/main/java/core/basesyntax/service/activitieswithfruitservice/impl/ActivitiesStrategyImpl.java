package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesStrategy;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    @Override
    public void performTransaction(String code, FruitTransaction fruitTransaction) {
        switch (code) {
            case "b":
                new BalanceFruitActivitiesServiceImpl().performTransaction(fruitTransaction);
                break;
            case "p":
                new PurchaseFruitActivitiesServiceImpl().performTransaction(fruitTransaction);
                break;
            case "r":
                new ReturnFruitActivitiesServiceImpl().performTransaction(fruitTransaction);
                break;
            case "s":
                new SupplyFruitActivitiesServiceImpl().performTransaction(fruitTransaction);
                break;
            default:
                throw new RuntimeException("Input code is not correct");
        }
    }
}
