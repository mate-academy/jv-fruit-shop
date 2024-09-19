package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    void add(String fruit, int quantity);

    void change(String fruit, int newQuantity);

    int get(String fruit);

    Map<String, Integer> getAll();
}
