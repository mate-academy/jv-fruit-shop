package impl;

import java.util.Map;
import service.ReportService;
import storage.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String HEAD = "fruit,quantity" + LINE_SEPARATOR;
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(HEAD);
        for (Map.Entry<String, Integer> entry : Storage.getFruitsStorage().entrySet()) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return builder.toString();
    }
}
