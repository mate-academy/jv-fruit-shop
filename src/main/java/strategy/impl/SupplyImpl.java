package strategy.impl;

import db.Warehouse;
import strategy.Supply;

public class SupplyImpl implements Supply {
    @Override
    public void addSupply(String fruit, int quantity) {
        int sum = quantity;
        if (Warehouse.getStorage().get(Warehouse.TypeFruit.valueOf(fruit)) != null) {
            sum = sum + Warehouse.getStorage().get(Warehouse.TypeFruit.valueOf(fruit));
        }
        Warehouse.getStorage().put(Warehouse.TypeFruit.valueOf(fruit), sum);
    }
}
