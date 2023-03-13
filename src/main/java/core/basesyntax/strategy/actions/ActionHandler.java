package core.basesyntax.strategy.actions;

import java.util.Map;

public interface ActionHandler {

    String SPLITTER = ",";
    void apply(Map<String, Integer> map, String data);
}
