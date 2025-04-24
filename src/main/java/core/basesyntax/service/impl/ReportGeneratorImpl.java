package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String RESULT_FILE_FIELDS = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(RESULT_FILE_FIELDS);
        for (Map.Entry<String, Integer> entry : Storage.finalData.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                        .append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
