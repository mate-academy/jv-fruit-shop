package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String REPORT_HEADER = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> data : Storage.FRUIT_STORAGE.entrySet()) {
            builder.append(data.getKey())
                    .append(COMMA_SEPARATOR)
                    .append(data.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
