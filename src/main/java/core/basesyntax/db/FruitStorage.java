package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    public static final List<Fruit> fruits = new ArrayList<>();

    public static boolean contains(Fruit searchedFruit) {
        for (Fruit fruit : fruits) {
            if (fruit.equals(searchedFruit)) {
                return true;
            }
        }
        return false;
    }
}
