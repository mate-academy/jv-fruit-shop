package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> FRUIT_TYPES_AND_QUANTITY = new HashMap<>();

    public static Map<String, Integer> getFruitTypesAndQuantity() {
        return FRUIT_TYPES_AND_QUANTITY;
    }
}
