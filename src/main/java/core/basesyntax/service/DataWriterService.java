package core.basesyntax.service;

import java.util.Map;

public interface DataWriterService {
    void writeReportToFile(Map<String, Integer> report, String fileName);
}
