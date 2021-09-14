package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportService {
    String createReport(Map<Fruit, Integer> mapQuantityFruit, String titleReport);
}
