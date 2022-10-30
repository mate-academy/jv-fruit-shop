package service.strategy_of_activities.strategyImpl;

import dao.impl.SubstrackFromStorageImpl;
import service.strategy_of_activities.DoActivities;

public class PurchaseActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        new SubstrackFromStorageImpl().subtrackFromStorage(fruit, number);
    }
}
