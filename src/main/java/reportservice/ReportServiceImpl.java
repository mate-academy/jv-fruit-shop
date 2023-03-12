package reportservice;

import db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder builderForGetContentFromMap = new StringBuilder();
        for (Map.Entry<String, Integer> entry: Storage.getStorage().entrySet()) {
            builderForGetContentFromMap.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(",");
        }
        StringBuilder contentForReportFile = new StringBuilder();
        String[] splitForWritingInNewFile = builderForGetContentFromMap.toString().split(",");
        for (int i = 0; i < splitForWritingInNewFile.length; i += 2) {
            contentForReportFile.append(splitForWritingInNewFile[i])
                    .append(",")
                    .append(splitForWritingInNewFile[i + 1])
                    .append("\n");
        }
        return contentForReportFile.toString();
    }
}
