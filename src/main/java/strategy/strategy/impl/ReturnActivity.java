package strategy.strategy.impl;

import dao.impl.OperatorForDbMap;
import strategy.DoActivities;

public class ReturnActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        if (!OperatorForDbMap.operator.isInStorage(fruit)) {
            throw new RuntimeException("There was no fruit like that in the storage");
        }
        OperatorForDbMap.operator.subtrackFromStorage(fruit, number);
    }
}
