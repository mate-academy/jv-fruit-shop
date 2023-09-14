package core.basesyntax.service;

import java.util.List;

public interface ReportWriter {
    void writeReport(String name, List<String> textReport);
}
