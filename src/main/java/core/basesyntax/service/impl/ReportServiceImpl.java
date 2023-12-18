package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String report() {
        StringBuilder report = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitQuantities.entrySet()) {
            report.append(entry.getKey())
                    .append(SEPARATOR);
                                .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
