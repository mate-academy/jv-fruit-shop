package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String RECORD_DIVIDER = ",";
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public String createReport(Map<Fruit, Integer> fruitsDataMap) {
        StringBuilder stringBuilder = new StringBuilder().append(HEADER);
        for (Map.Entry<Fruit, Integer> record : fruitsDataMap.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(record.getKey().getName())
                    .append(RECORD_DIVIDER)
                    .append(record.getValue());
        }
        return stringBuilder.toString();
    }
}
