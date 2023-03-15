package serviceimpl;

import db.Storage;
import service.ReportService;

import java.util.Map;

public class ReportImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String DATA_SEPARATOR = ";";

    @Override
    public String newReport() {
        StringBuilder stringBuilder = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DATA_SEPARATOR)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
