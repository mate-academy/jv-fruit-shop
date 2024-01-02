package core.basesyntax.services.fileprocessing;

import java.util.Map;

public interface ReportGenerator {
    StringBuilder generateReport(Map<String, Integer> fruitsTypeAndAmount);
}
