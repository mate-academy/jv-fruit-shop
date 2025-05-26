package core.basesyntax.report.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();

        boolean firstLine = true;
        for (Map.Entry<String, FruitOperation> entry : Storage.SHOP_STORE.entrySet()) {
            if (!firstLine) {
                stringBuilder.append(System.lineSeparator());
            }
            firstLine = false;

            String fruitName = entry.getKey();
            int quantity = entry.getValue().getQuantity();
            stringBuilder.append(fruitName)
                    .append(SEPARATOR)
                    .append(quantity);
        }

        return stringBuilder.toString();
    }
}
