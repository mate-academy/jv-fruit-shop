package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public String getReport() {
        Map<String, Integer> storage = Storage.getStorage();
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey());
            report.append(",");
            report.append(entry.getValue());
            report.append("\n");
        }
        return report.toString();
    }
}
