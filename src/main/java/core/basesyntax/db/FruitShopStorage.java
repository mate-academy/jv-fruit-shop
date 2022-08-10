package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitShopStorage {
    public static final List<Fruit> storageFruits = new ArrayList<>();

    public static List<Fruit> getStorageFruits() {
        return storageFruits;
    }
}
