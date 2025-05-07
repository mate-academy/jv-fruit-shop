package core.basesyntax.report.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (FruitOperation fruitOperation : Storage.SHOP_STORE) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruitOperation.getFruit())
                    .append(SEPARATOR)
                    .append(fruitOperation.getQuantity());
        }
        return stringBuilder.toString();
    }
}
