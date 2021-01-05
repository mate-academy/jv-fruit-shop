package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public final class DataBase {
    private static final Map<Fruit, Integer> listItems = new HashMap<>();

    public static Map<Fruit, Integer> getListItems() {
        return listItems;
    }
}
