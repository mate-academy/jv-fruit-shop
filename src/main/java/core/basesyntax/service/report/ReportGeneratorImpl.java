package core.basesyntax.service.report;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
