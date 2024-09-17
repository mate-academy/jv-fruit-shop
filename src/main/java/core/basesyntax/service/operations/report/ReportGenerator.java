package core.basesyntax.service.operations.report;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportGenerator {
    public String generateReportContent(Map<Fruit, Integer> storage);
}
