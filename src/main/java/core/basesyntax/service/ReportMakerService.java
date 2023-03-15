package core.basesyntax.service;

import java.util.Map;

public interface ReportMakerService {
    void createReport(Map<String, Integer> storage, String path);
}
