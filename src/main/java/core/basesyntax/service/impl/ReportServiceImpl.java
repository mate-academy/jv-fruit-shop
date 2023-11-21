package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDB;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "Fruit,Value";

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitDB.FRUIT_DATA_BASE.entrySet()) {
            report.append(entry.getKey())
                    .append(".")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
