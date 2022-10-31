package core.basesyntax.strategy;

import java.util.Optional;

public interface Strategy<K, V> {
    Optional<V> getService(K key);
}
