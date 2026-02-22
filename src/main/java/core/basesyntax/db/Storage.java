package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    boolean update(String fruit, String quantity);

    Map<String, String> snapshot();

    String get(String key);
}
