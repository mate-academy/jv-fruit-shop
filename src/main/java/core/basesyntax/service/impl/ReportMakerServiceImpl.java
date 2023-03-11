package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String HEADER = "fruit,quantity";
    private static final String NEW_LINE = "\n";
    private static final char SEPARATOR = ',';

    @Override
    public String makeReport(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> pair : Storage.getStorage().entrySet()) {
            report.append(NEW_LINE)
                    .append(pair.getKey())
                    .append(SEPARATOR)
                    .append(pair.getValue());
        }
        return report.toString();
    }
}
