package service.impl;

import database.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String WORDS_SEPARATOR = ",";
    private static final String NEW_LINE = "\n";
    private static final String HEAD_OF_FILE = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD_OF_FILE);
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
