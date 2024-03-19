package core.basesyntax.utility;

public class Pair<K, V> {
    private final K first;
    private final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}
