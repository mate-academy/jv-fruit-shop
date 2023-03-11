package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String formReport() {
        StringBuilder reportCreator = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> element : Storage.storage.entrySet()) {
            reportCreator.append(System.lineSeparator())
                    .append(element.getKey())
                    .append(COMA_SEPARATOR)
                    .append(element.getValue());
        }
        return reportCreator.toString();
    }
}
