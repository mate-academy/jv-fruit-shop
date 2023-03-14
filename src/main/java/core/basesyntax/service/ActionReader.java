package core.basesyntax.service;

import core.basesyntax.strategy.actions.ActionHandler;

import java.util.List;
import java.util.Map;

public interface ActionReader {
    Map<String, Integer> inputDataToMap(List<ActionHandler> possibleActions, String path);
    void outputMapToFile(Map<String, Integer> data, String path);
}
