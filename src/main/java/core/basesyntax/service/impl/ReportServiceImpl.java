package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADING = "fruit,quantity" + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADING);
        for (Map.Entry<String, Integer> entry : Storage.storageContents.entrySet()) {
            stringBuilder.append(entry.getKey() + SEPARATOR
                    + entry.getValue() + System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
