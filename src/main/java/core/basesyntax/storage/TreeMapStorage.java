package core.basesyntax.storage;

import core.basesyntax.products.Fruit;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapStorage {
    public static Map<LocalDate, Fruit> treeMapStorage = new TreeMap<>();
}
