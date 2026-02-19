package core.basesyntax.generator;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> mapObject : Storage.getStorage().entrySet()) {
            report.append(mapObject.getKey())
                    .append(COMMA)
                    .append(mapObject.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
