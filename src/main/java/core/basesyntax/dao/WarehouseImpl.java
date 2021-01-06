package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    @Override
    public void addItem(Fruit fruit, int amount) {
        if (DataBase.getListItems().containsKey(fruit)) {
            DataBase.getListItems().replace(fruit, (amount + DataBase.getListItems().get(fruit)));
        } else {
            DataBase.getListItems().put(fruit, amount);
        }
    }

    @Override
    public void replace(Fruit fruit, int amount) {
        if (DataBase.getListItems().get(fruit) == null) {
            DataBase.getListItems().put(fruit, amount);
        } else {
            DataBase.getListItems().replace(fruit, (amount));
        }
    }

    public Map<Fruit, Integer> getListItems() {
        return DataBase.getListItems();
    }

    @Override
    public int getAmountOfItem(Fruit fruit) {
        return DataBase.getListItems().getOrDefault(fruit, 0);
    }

    @Override
    public void getItemFrom(Fruit fruit, int amount) {
        DataBase.getListItems().replace(fruit, (DataBase.getListItems().get(fruit) - amount));
    }
}
