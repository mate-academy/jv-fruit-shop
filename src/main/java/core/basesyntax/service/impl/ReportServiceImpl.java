package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String FIRST_LINE_OF_REPORT = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(FIRST_LINE_OF_REPORT + System.lineSeparator());
        for (Map.Entry<String, Integer> data : Storage.fruitStorage.entrySet()) {
            builder.append(data.getKey());
            builder.append(COMMA_SEPARATOR);
            builder.append(data.getValue());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
