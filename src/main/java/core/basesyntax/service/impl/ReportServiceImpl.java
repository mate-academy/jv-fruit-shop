package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    final String REPORT_HEADER = "\n";
    @Override
    public String createReport() {
        StringBuilder line = new StringBuilder();
        line.append("fruit,quantity" + REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            line.append(entry.getKey() + "," + entry.getValue() + REPORT_HEADER);
        }
        return line.toString();
    }
}
