package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_CAPTION = "fruit,quantity";
    private static final String REPORT_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder stringForReport = new StringBuilder()
                .append(REPORT_CAPTION)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> mapValue : Storage.fruits.entrySet()) {
            stringForReport.append(mapValue.getKey())
                    .append(REPORT_SEPARATOR)
                    .append(mapValue.getValue())
                    .append(System.lineSeparator());
        }
        return stringForReport.toString();
    }
}
