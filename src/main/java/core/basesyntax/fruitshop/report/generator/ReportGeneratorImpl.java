package core.basesyntax.fruitshop.report.generator;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE);
        for (Map.Entry<String, Integer> map : Storage.getFruitStorage().entrySet()) {
            builder.append(map.getKey())
                    .append(",")
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
