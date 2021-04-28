package core.basesyntax.fruitshop.report.generator;

import java.util.Map;

public interface ReportGenerator {
    void generateReport(String toFile, Map<String, Integer> storage);
}
