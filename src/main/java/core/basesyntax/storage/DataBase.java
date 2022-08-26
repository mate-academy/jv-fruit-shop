package core.basesyntax.storage;

import java.util.Map;

public interface DataBase {
    void add(String fruit, Integer quantity);

    void remove(String fruit, Integer quantity);

    Map<String, Integer> getAll();
}
