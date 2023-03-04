package reportservice;

import db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder contentForReportFile = new StringBuilder();
        for (Map.Entry<String, Integer> entry: Storage.getStorage().entrySet()) {
            contentForReportFile.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(",");
        }
        return contentForReportFile.toString();
    }
}
