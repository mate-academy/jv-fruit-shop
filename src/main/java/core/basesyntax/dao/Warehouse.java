package core.basesyntax.dao;

import java.util.Map;

public interface Warehouse {
    public void addItem(String fruit, int amount);

    public void replace(String fruit, int amount);

    public Map<String, Integer> getListItems();

    public int getAmountOfItem(String fruit);

    public void getItemFrom(String name, int amount);
}
