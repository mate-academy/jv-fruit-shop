package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportCreator {
    String createReport(Map<Fruit, Integer> storage);
}
