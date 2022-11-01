package strategy.strategy.impl;

import dao.impl.OperatorForDbMap;
import java.util.NoSuchElementException;
import strategy.DoActivities;

public class PurchaseActivity implements DoActivities {
    @Override
    public void doActivity(String fruit, Integer number) {
        if (!OperatorForDbMap.operator.isInStorage(fruit)) {
            throw new NoSuchElementException("There was no such fruit in the shop: " + fruit);
        }
        OperatorForDbMap.operator.subtrackFromStorage(fruit, number);
    }
}
