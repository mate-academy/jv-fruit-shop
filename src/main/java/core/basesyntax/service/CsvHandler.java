package core.basesyntax.service;

import core.basesyntax.model.Action;
import java.util.List;
import java.util.Map;

public interface CsvHandler {
    List<Action> read(String path);

    void report(Map<String, Integer> report, String path);
}
