package core.basesyntax.dao;

public interface ProductDao {
    int add(String key, int newValue);

    Integer getValue(String key);
}
