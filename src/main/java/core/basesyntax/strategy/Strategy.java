package core.basesyntax.strategy;

public interface Strategy<T, K> {
    T get(K key);
}
