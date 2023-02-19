package core.basesyntax.service;

import java.util.Map;

public interface ReportService {
    String getReportFruitStorage(String information);

    String getInfoForReport(Map<String, Integer> mapHandler);
}
