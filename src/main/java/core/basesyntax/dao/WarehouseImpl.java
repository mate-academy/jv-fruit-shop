package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private final Map<String, Integer> listItems = new HashMap<>();

    @Override
    public void addItem(String fruit, int amount) {
        if (listItems.containsKey(fruit)) {
            listItems.replace(fruit, (amount + listItems.get(fruit)));
        } else {
            listItems.put(fruit, amount);
        }
    }

    @Override
    public void replace(String fruit, int amount) {
        if (listItems.get(fruit) == null) {
            listItems.put(fruit, amount);
        } else {
            listItems.replace(fruit, (amount));
        }
    }

    @Override
    public Map<String, Integer> getListItems() {
        return listItems;
    }

    @Override
    public int getAmountOfItem(String fruit) {
        return listItems.getOrDefault(fruit, 0);
    }

    @Override
    public void getItemFrom(String fruit, int amount) {
        listItems.replace(fruit, (listItems.get(fruit) - amount));
    }
}
