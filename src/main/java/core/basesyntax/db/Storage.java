package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> fruitMap = new HashMap<>();

    public static void add(Fruit fruit, Integer integer) {
        fruitMap.put(fruit,integer);
    }

    public static Map<Fruit, Integer> getAll() {
        return fruitMap;
    }

    public static Integer get(Fruit fruit) {
        return fruitMap.get(fruit);
    }

    public void print() {
        System.out.println(fruitMap);
    }

}
