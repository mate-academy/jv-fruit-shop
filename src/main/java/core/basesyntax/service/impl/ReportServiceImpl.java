package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.getAll().entrySet()) {
            sb.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
