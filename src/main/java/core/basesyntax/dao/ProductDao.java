package core.basesyntax.dao;

public interface ProductDao<T> {
    T add(T product);
    T get(String productName);
}
