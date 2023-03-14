package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerateService;

public class ReportGenerateServiceImpl implements ReportGenerateService {
    private static final char COMMA = ',';
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createMessage() {
        StringBuilder reportBuilder = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry: Storage.fruits.entrySet()) {
            reportBuilder.append(System.lineSeparator()).append(entry.getKey())
                    .append(COMMA).append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
