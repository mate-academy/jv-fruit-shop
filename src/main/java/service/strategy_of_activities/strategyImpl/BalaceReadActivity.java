package service.strategy_of_activities.strategyImpl;


import dao.impl.AddToStorageImpl;
import service.strategy_of_activities.DoActivities;

public class BalaceReadActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        new AddToStorageImpl().writeToStorage(fruit, number);
    }
}
