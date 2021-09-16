package core.basesyntax.servise.activity;

import java.util.Map;

public interface ActivityHandler {
    public void action(String fruit, String quantity, Map<String, Integer> goalMap);
}
