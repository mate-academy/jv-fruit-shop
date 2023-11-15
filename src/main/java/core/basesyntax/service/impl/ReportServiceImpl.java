package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDB;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : FruitDB.FRUIT_DATA_BASE.entrySet()) {
            report.append(entry.getKey())
                    .append(".")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
