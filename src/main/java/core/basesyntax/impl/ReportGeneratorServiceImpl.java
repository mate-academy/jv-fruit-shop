package core.basesyntax.impl;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_LINE = System.lineSeparator();
    private static final String firstStringOfTheReport = "fruit,quantity";

    @Override
    public String generateReport(FruitShopStorage fruitShopStorage) {
        StringBuilder report = new StringBuilder();
        report.append(firstStringOfTheReport);
        for (String key : fruitShopStorage.getFruitShopStorage().keySet()) {
            report.append(SEPARATOR_LINE)
                    .append(key).append(SEPARATOR_COMMA)
                    .append(fruitShopStorage.getQuantity(key));
        }
        return report.toString();
    }
}
