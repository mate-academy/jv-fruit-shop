package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    public static final Map<String, Integer> FruitInventory = new HashMap<>();

    public static Map<String, Integer> getFruitInventory() {
        return FruitInventory;
    }
}
