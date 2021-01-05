package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<Fruit, Integer> fruitsAndAmountsMap = new HashMap<>();

}
