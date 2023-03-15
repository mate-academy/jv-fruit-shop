package core.basesyntax.strategy;

public interface SaveStrategy<T, S> {
    void save(T value, S storage);
}
