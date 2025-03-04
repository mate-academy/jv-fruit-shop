package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit, quantity";
    private static final String REPORT_INFORMATION_SPLIT_COMA = ", ";

    @Override
    public String getReport(ShopInventory shopInventory) {

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEADER)
                .append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : shopInventory.getFruitQuantity().entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(REPORT_INFORMATION_SPLIT_COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
