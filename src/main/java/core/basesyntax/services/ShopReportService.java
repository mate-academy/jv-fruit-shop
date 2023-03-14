package core.basesyntax.services;

import java.util.Map;

public interface ShopReportService {
    byte[] generateReport(Map<String, Integer> processedData);
}
