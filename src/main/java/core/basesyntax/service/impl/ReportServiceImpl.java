package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_LEGEND = "fruit,quantity";
    private final String separator = ",";
    private final StringBuilder reportBuilder = new StringBuilder();

    @Override
    public String getReport(Map<?, ?> formattedData) {
        reportBuilder.delete(0, reportBuilder.length());
        reportBuilder.append(REPORT_LEGEND);
        formattedData.forEach((key, value) -> reportBuilder
                .append(System.getProperty("line.separator"))
                .append(key)
                .append(separator)
                .append(value));
        return reportBuilder.toString();
    }

    @Override
    public Map<String, Integer> getDataForReport() {
        return Storage.storeItems.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
