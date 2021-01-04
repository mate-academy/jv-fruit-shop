package core.basesyntax.dao;

import java.util.Map;

public interface Warehouse {
    void addItem(String fruit, int amount);

    void replace(String fruit, int amount);

    Map<String, Integer> getListItems();

    int getAmountOfItem(String fruit);

    void getItemFrom(String name, int amount);
}
