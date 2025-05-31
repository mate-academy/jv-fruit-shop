package core.basesyntax.report.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit" + SEPARATOR + "quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);

        for (Map.Entry<String, FruitOperation> entry : Storage.SHOP_STORE.entrySet()) {
            stringBuilder.append(System.lineSeparator());

            String fruitName = entry.getKey();
            int quantity = entry.getValue().getQuantity();
            stringBuilder.append(fruitName)
                    .append(SEPARATOR)
                    .append(quantity);
        }

        return stringBuilder.toString();
    }
}
