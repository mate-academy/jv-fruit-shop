package core.basesyntax.dao;

import java.util.Map;

public interface Warehouse {
    public void addFruit(String fruit, int amount);

    public void replace(String fruit, int amount);

    public Map<String, Integer> getListFruits();

    public int getAmountOfFruit(String fruit);

    public void getFruitFrom(String name, int amount);
}
