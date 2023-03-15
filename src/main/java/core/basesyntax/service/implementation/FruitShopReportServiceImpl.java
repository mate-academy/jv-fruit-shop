package core.basesyntax.service.implementation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.FruitShopReportService;
import java.util.Set;

public class FruitShopReportServiceImpl implements FruitShopReportService {
    private static final String REPORT_HEADER = "fruit, quantity" + System.lineSeparator();
    private static final String REPORT_SEPARATOR = ", ";
    private static final String REPORT_NEW_LINE = "\n";

    @Override
    public String createReport() {
        String report = REPORT_HEADER;
        Set<String> fruits = FruitStorage.getKeys();
        for (String fruit : fruits) {
            report += fruit + REPORT_SEPARATOR + FruitStorage.get(fruit) + REPORT_NEW_LINE;
        }
        return report.trim();
    }
}
