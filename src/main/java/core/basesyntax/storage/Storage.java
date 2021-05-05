package core.basesyntax.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static List<String> toList() {
        List<String> output = new ArrayList<>();
        for (String key : fruits.keySet()) {
            output.add(key + "," + fruits.get(key));
        }
        return output;
    }
}

