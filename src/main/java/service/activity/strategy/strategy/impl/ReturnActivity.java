package service.activity.strategy.strategy.impl;

import dao.impl.TestOfPresent;
import service.activity.strategy.DoActivities;

public class ReturnActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        if (!new TestOfPresent().isInStorage(fruit)) {
            throw new RuntimeException("There was no fruit like that in the storage");
        }
        new SupplyActivity().doActivity(fruit, number);
    }
}
