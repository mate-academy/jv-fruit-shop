package core.basesyntax.storage;

import java.util.Map;

public interface Storage {
    Map<String, Integer> getAll();

    Integer getQuantity(String fruit);

    void put(String fruit, int quantity);

    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);
}
