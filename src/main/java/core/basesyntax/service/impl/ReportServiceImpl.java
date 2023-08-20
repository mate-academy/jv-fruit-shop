package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.math.BigDecimal;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    public ReportServiceImpl() {
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, BigDecimal> fruit : FruitStorage.fruits.entrySet()) {
            report.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
