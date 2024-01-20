package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder line = new StringBuilder();
        line.append("fruit,quantity" + "\n");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            line.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        return line.toString();
    }
}
