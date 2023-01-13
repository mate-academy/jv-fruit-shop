package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(REPORT_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> row : Storage.storage.entrySet()) {
            StringBuilder reportLine = new StringBuilder(row.getKey());
            reportLine.append(COMMA)
                    .append(row.getValue())
                    .append(System.lineSeparator());
            builder.append(reportLine);
        }
        return builder.toString();
    }
}
