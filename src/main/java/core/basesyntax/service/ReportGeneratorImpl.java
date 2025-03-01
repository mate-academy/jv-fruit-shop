package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        ShopInventory shopInventory = new ShopInventory();

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit, quantity")
                .append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : shopInventory.getFruitQuantity().entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(", ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
