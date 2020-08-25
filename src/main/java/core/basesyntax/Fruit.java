package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Fruit {
    private String name;
    private Map<LocalDate, Integer> storage;

    public Fruit(String name) {
        this.name = name;
        storage = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setStorage(Map<LocalDate, Integer> storage) {
        this.storage = storage;
    }

    public Map<LocalDate, Integer> getStorage() {
        return storage;
    }
}
