package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface Warehouse {
    void addItem(Fruit fruit, int amount);

    void replace(Fruit fruit, int amount);

    Map<Fruit, Integer> getListItems();

    int getAmountOfItem(Fruit fruit);

    void getItemFrom(Fruit fruit, int amount);
}
