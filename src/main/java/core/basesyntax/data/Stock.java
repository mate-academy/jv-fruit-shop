package core.basesyntax.data;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private final Map<String, Integer> data = new HashMap<>();

    public Map<String, Integer> getData() {
        return data;
    }
}
