package core.basesyntax.storage;

import java.util.Map;
import java.util.Set;

public interface Storage {
    void add(String fruit, Integer quantity);

    void remove(String fruit, Integer quantity);

    Set<Map.Entry<String, Integer>> getEntrySet();
}
