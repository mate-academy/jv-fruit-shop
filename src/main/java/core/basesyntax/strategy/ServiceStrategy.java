package core.basesyntax.strategy;

import java.util.Map;
import java.util.Optional;

public class ServiceStrategy<K, V> implements Strategy<K, V> {
    private Map<K, V> strategyMap;

    public ServiceStrategy(Map<K, V> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public Optional<V> getService(K key) {
        return Optional.ofNullable(strategyMap.get(key));
    }
}
