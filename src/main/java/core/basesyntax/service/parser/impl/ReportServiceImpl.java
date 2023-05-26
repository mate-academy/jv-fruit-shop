package core.basesyntax.service.parser.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.parser.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> pair : Storage.getFruitStorage().entrySet()) {
            builder.append(pair.getKey())
                    .append(COMMA)
                    .append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
