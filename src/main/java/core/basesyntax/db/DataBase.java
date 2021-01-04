package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public final class DataBase {
    private static final Map<String, Integer> listItems = new HashMap<>();

    public static Map<String, Integer> getListItems() {
        return listItems;
    }
}
