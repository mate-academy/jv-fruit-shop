package strategy.strategy.impl;

import dao.impl.AddToStorageImpl;
import strategy.DoActivities;

public class SupplyActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        new AddToStorageImpl().writeToStorage(fruit,number);
    }
}
