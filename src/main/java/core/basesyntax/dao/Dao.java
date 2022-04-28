package core.basesyntax.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T create(String name, int quantity);

    void saveToStorage(T element);

    Optional<T> get(T element);

    List<T> getAll();

    T update(T element);

    boolean delete(T element);
}
