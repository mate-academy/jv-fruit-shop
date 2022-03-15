package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    public static final List<Fruit> fruits = new ArrayList<>();

    // Check if the storage already contains such type of fruits
    // without mentioning their quantity, cause it doesn't matter
    // That's why boolean equals() doesn't compare quantity for fruits
    // and why usual boolean contains() doesn't pass in this case
    public static boolean contains(Fruit searchedFruit) {
        for (Fruit fruit : fruits) {
            if (fruit.equals(searchedFruit)) {
                return true;
            }
        }
        return false;
    }
}
