package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return "fruit,quantity" + report;
    }
}
