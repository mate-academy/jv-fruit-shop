package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    private HashMap<String, Integer> fruits;

    public Storage() {
        this.fruits = new HashMap<>();
    }

    public HashMap<String, Integer> getFruits() {
        return fruits;
    }

    public void setFruits(HashMap<String, Integer> fruits) {
        this.fruits = fruits;
    }
}
