package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> FRUIT_KINDS_AND_QUANTITY = new HashMap<>();

    public static Map<String, Integer> getFruitKindsAndQuantity() {
        return FRUIT_KINDS_AND_QUANTITY;
    }
}
