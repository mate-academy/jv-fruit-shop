package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportMakerService {
    String getReport(Map<Fruit, Integer> map);
}
