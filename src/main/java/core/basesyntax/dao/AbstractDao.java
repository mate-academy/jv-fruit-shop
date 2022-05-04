package core.basesyntax.dao;

import java.util.List;
import java.util.Optional;

public interface AbstractDao<T> {
    T create(String name, int quantity);

    void save(T element);

    Optional<T> get(String fruitName);

    List<T> getAll();

    T update(T element);

    boolean delete(T element);
}
