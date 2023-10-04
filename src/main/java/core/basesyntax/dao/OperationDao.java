package core.basesyntax.dao;

public interface OperationDao {

    void put(String key, Integer value);

    Integer get(String key);
}
