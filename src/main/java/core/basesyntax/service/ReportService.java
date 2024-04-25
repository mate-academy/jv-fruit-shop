package core.basesyntax.service;

import java.util.List;

public interface ReportService {
    List<String> calculateDataForReport(List<String> readFromFile);
}
