package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> data = new HashMap<>();

    public Map<Fruit, Integer> getData() {
        return data;
    }

    public void setData(Map<Fruit, Integer> data) {
        this.data = data;
    }
}
