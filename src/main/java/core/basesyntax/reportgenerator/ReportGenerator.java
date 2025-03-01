package core.basesyntax.reportgenerator;

import java.util.List;

public interface ReportGenerator {
    List<String> generateReport(List<String[]> parsedData);
}
