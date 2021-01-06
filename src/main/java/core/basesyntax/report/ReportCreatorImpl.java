package core.basesyntax.report;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruitsMap().entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey().getName())
                    .append(SPLITTER).append(entry.getValue());
        }
        return report.toString();
    }
}
