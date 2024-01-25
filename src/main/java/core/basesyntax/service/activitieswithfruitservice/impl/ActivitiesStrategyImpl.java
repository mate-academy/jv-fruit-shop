package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesStrategy;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    @Override
    public void getActivitiesWithFruit(String code, FruitTransaction fruitTransaction) {
        switch (code) {
            case "b":
                new BalanceFruitActivitiesServiceImpl().activitiesWithFruit(fruitTransaction);
                break;
            case "p":
                new PurchaseFruitActivitiesServiceImpl().activitiesWithFruit(fruitTransaction);
                break;
            case "r":
                new ReturnFruitActivitiesServiceImpl().activitiesWithFruit(fruitTransaction);
                break;
            case "s":
                new SupplyFruitActivitiesServiceImpl().activitiesWithFruit(fruitTransaction);
                break;
            default:
                throw new RuntimeException("Input code is not correct");
        }
    }
}
