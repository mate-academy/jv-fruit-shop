package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerationService;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public String generate() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(SEPARATOR);
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(SEPARATOR);
        }
        return report.toString();
    }
}
