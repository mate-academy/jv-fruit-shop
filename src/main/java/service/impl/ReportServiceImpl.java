package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String Separator = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String createReport() {
        StringBuilder builder = new StringBuilder(HEADER_LINE);
        for (Map.Entry<String, Integer> entry : Storage.getFruitsBalanceReport().entrySet()) {
            builder.append(LINE_SEPARATOR)
                    .append(entry.getKey())
                    .append(Separator)
                    .append(entry.getValue())
            ;
        }
        return builder.toString();
    }
}
