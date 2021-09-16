package core.basesyntax.servise.activity;

import java.util.Map;

public interface ActivityHandler {
    void act(String fruit, String quantity, Map<String, Integer> goalMap);
}
