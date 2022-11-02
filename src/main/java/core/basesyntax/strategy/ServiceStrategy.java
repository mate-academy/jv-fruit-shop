package core.basesyntax.strategy;

import java.util.Map;

public class ServiceStrategy<K, V> implements Strategy<K, V> {
    private final Map<K, V> strategyMap;

    public ServiceStrategy(Map<K, V> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public V getService(K key) {
        return strategyMap.get(key);
    }
}
