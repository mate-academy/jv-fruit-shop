package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String report() {
        StringBuilder report = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitQuantities.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

