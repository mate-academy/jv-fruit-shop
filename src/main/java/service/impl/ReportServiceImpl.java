package service.impl;

import java.util.Map;
import java.util.Set;
import service.general.ReportService;
import storage.ReportStorage;

public class ReportServiceImpl implements ReportService {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String UNIX_LINE = "\n";
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
            stringBuilder.append(UNIX_LINE)
                    .append(e.getKey())
                    .append(DATA_SEPARATOR)
                    .append(e.getValue());
        }
        String report = stringBuilder.toString();
        reportStorage = new ReportStorage(report);
    }
}
