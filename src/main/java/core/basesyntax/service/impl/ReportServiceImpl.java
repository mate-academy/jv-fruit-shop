package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> map : Storage.storageFruits.entrySet()) {
            reportBuilder.append(map.getKey())
                    .append(",")
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
