package strategy.impl;

import db.Warehouse;
import strategy.Return;

public class ReturnImpl implements Return {
    @Override
    public void addReturn(String fruit, int quantity) {
        int sumReturn = quantity;
        if (Warehouse.getStorage().get(Warehouse.TypeFruit.valueOf(fruit)) != null) {
            sumReturn = sumReturn + Warehouse.getStorage().get(Warehouse.TypeFruit.valueOf(fruit));
        }
        Warehouse.getStorage().put(Warehouse.TypeFruit.valueOf(fruit), sumReturn);
    }
}
