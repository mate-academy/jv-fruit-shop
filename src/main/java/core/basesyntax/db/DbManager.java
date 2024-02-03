package core.basesyntax.db;

import java.util.List;

public interface DbManager<T, V> {
    List<T> getAll();

    void putAll(List<V> resultingRow);
}
