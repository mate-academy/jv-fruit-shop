package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface FileReporting {
    List<String> getReport(Map<Fruit, Integer> fruits);
}
