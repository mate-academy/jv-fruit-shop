package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Fruit> fruits;

    public Storage() {
        fruits = new ArrayList<>();
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
