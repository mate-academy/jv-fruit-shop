package core.basesyntax;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    public static final Map<String, Integer> inventory = new ConcurrentHashMap<>();
}
