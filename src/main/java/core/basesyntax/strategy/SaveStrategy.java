package core.basesyntax.strategy;

public interface SaveStrategy<T, Dao> {
    void save(T value, Dao storage);
}
