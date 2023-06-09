package core.basesyntax.impl;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_LINE = System.lineSeparator();
    private static final String firstStringOfTheReport = "fruit,quantity";

    @Override
    public String generateReport(FruitShopStorage fruitShopStorage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstStringOfTheReport);
        for (String key : fruitShopStorage.getFruitShopStorage().keySet()) {
            stringBuilder.append(SEPARATOR_LINE)
                    .append(key).append(SEPARATOR_COMMA)
                    .append(fruitShopStorage.getQuantity(key));
        }
        return stringBuilder.toString();
    }
}
