package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReportService() {
        StringBuilder bd = new StringBuilder("fruit, quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.FruitStorage.entrySet()) {
            bd.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return bd.toString();
    }
}
