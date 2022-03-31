package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String COMMA = ",";
    
    @Override
    public StringBuilder makeReport() {
        StringBuilder reportMaker = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> element : Storage.storage.entrySet()) {
            reportMaker.append(System.lineSeparator())
                    .append(element.getKey())
                    .append(COMMA)
                    .append(element.getValue());
        }
        return reportMaker;
    }
}
