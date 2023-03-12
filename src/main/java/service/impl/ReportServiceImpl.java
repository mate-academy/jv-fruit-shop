package service.impl;

import java.util.Map;
import java.util.Set;
import service.ReportService;
import storage.ReportStorage;

public class ReportServiceImpl implements ReportService {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();
    private static final Set<Map.Entry<String, Integer>> ENTRIES =
            new DataStorageServiceImpl().getFruitMap().entrySet();
    private ReportStorage reportStorage;

    @Override
    public String getReport() {
        makeReport();
        return reportStorage.getReport();
    }

    private void makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER);
        for (Map.Entry<String, Integer> e : ENTRIES) {
            stringBuilder.append(NEW_LINE)
                    .append(e.getKey())
                    .append(DATA_SEPARATOR)
                    .append(e.getValue());
        }
        stringBuilder.append(NEW_LINE);
        String report = stringBuilder.toString();
        reportStorage = new ReportStorage(report);
    }
}
