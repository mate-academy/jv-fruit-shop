package service.activity.strategy.strategy.impl;

import dao.impl.AddToStorageImpl;
import service.activity.strategy.DoActivities;

public class BalaceReadActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        new AddToStorageImpl().writeToStorage(fruit, number);
    }
}
