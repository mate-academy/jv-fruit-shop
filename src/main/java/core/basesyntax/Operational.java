package core.basesyntax;

import java.util.Map;

public interface Operational<K, V> {

    void operation(Transaction transaction, Map<String, Integer> map);
}
