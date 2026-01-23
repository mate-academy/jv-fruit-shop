package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    Map<String, Integer> getAll();

    int getQuantity(String fruit);

    void putQuantity(String fruit, int qty);

}
