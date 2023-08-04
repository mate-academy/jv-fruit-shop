package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.service.ReportCreationService;
import java.util.Map;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String COMMA_SIGN = ",";
    private static final String REPORT_TABLE_HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_TABLE_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> data : FruitsStorage.fruitsStorage.entrySet()) {
            stringBuilder.append(data.getKey())
                    .append(COMMA_SIGN)
                    .append(data.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
