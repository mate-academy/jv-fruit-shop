package core.basesyntax.service.implementation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.FruitShopReportService;
import java.util.Map;

public class FruitShopReportServiceImpl implements FruitShopReportService {
    private static final String REPORT_HEADER = "fruit, quantity" + System.lineSeparator();
    private static final String REPORT_SEPARATOR = ", ";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : FruitStorage.getEntries()) {
            report.append(entry.getKey()).append(REPORT_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
