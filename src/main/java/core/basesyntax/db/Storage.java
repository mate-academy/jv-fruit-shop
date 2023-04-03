package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> remnantData;

    public Storage(Map<Fruit, Integer> remnantData) {
        this.remnantData = remnantData;
    }

    public Map<Fruit, Integer> get() {
        return remnantData;
    }
}
