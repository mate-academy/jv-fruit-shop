package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportService {
    String makeReport(Map<Fruit, Integer> data);
}
