package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface DailyReportService {
    String createReport(Map<Fruit, Integer> totalFruitAmount);
}
