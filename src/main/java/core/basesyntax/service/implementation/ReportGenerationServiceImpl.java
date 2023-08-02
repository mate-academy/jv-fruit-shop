package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerationService;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    public static final String COMA = ",";
    public static final String HEADER = "fruit,quantity";

    @Override
    public String generate() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
