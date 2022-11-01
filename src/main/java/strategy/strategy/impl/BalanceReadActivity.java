package strategy.strategy.impl;

import dao.impl.OperatorForDbMap;
import strategy.DoActivities;

public class BalanceReadActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        OperatorForDbMap.operator.writeToStorage(fruit, number);
    }
}
