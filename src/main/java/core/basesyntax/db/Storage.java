package core.basesyntax.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Storage {
    Map<String, Integer> storage = new HashMap<>();
    List<String> getAll();
}
