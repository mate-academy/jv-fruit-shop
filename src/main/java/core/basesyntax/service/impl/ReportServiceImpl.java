package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DELIMITER = ",";

    @Override
    public String reportPreparation() {
        Map<String, Integer> reportMap = Storage.fruitsStorage;
        StringBuilder reportString = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            reportString.append(entry.getKey()).append(DELIMITER).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportString.toString();
    }
}
