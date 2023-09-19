package service.impl;

import java.util.Map;
import service.ReportService;
import storage.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_RESULT_LINE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_RESULT_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits : Storage.getStorage().entrySet()) {
            stringBuilder.append(fruits.getKey()).append(COMMA).append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
