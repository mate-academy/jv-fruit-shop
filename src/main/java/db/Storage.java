package db;

import model.Fruit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    public static final Map<Fruit, Integer> fruits = new HashMap<>();
    public static final Set<String> validFruitNames = Set.of("apple", "banana");
    public static final Set<String> validOperations = Set.of("b", "p", "r", "s");
}
