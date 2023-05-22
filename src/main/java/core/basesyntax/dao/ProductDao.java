package core.basesyntax.dao;

public interface ProductDao<T, V> {
    V put(T product, V value);

    V get(T product);
    void clear();
}
