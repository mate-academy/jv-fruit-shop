package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private Map<String, Integer> listFruits = new HashMap<>();

    @Override
    public void addFruit(String fruit, int amount) {
        if (listFruits.containsKey(fruit)) {
            listFruits.replace(fruit, (amount + listFruits.get(fruit)));
        } else {
            listFruits.put(fruit, amount);
        }
    }

    @Override
    public void replace(String fruit, int amount) {
        if (listFruits.get(fruit) == null) {
            listFruits.put(fruit, amount);
        } else {
            listFruits.replace(fruit, (amount));
        }
    }

    @Override
    public Map<String, Integer> getListFruits() {
        return listFruits;
    }

    @Override
    public int getAmountOfFruit(String fruit) {
        return listFruits.getOrDefault(fruit, 0);
    }

    @Override
    public void getFruitFrom(String fruit, int amount) {
        listFruits.replace(fruit, (listFruits.get(fruit) - amount));
    }
}
