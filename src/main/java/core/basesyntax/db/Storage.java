package core.basesyntax.db;

public interface Storage {

    boolean create(String fruit, Integer quantity);

    Integer read(String fruit);

    Iterable<String> getAllKeys();

    boolean update(String fruit, Integer quantity);

    boolean delete(String fruit);
}
