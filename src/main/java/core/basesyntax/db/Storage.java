package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Fruit> fruits = new ArrayList<>();
    public static final List<String> stringList = new ArrayList<>();
    public static final Fruit banana = new Fruit("banana", 0);
    public static final Fruit apple = new Fruit("apple", 0);
}
