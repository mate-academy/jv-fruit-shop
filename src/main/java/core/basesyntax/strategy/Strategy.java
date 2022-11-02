package core.basesyntax.strategy;

public interface Strategy<K, V> {
    V getService(K key);
}
