package strategy.strategy.impl;

import dao.IsInStorage;
import dao.impl.SubstrackFromStorageImpl;
import dao.impl.TestOfPresent;
import java.util.NoSuchElementException;
import strategy.DoActivities;

public class PurchaseActivity implements DoActivities {

    @Override
    public void doActivity(String fruit, Integer number) {
        IsInStorage test = new TestOfPresent();
        if (!test.isInStorage(fruit)) {
            throw new NoSuchElementException("There was no such fruit in the shop: " + fruit);
        }
        new SubstrackFromStorageImpl().subtrackFromStorage(fruit, number);
    }
}
