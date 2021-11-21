package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Fruit> fruitsStore = new ArrayList<>();

    public static List<Fruit> getStore() {
        return fruitsStore;
    }
}
